package com.zybr.admin.controller;

import com.zybr.admin.AdminBaseController;
import com.zybr.common.dao.zybr.bean.user.Product;
import com.zybr.common.dao.zybr.bean.user.ProductType;
import com.zybr.common.dao.zybr.param.user.ProductParam;
import com.zybr.common.dao.zybr.param.user.ProductTypeParam;
import com.zybr.common.dao.zybr.service.user.ProductTypeWrapService;
import com.zybr.common.dao.zybr.service.user.ProductWrapService;
import com.zybr.common.json.ResultMessage;
import com.zybr.common.misc.CodeTool;
import com.zybr.common.misc.Constant;
import com.zybr.common.misc.MessageException;
import com.zybr.common.misc.PageBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pst on 15-4-29.
 */
@Controller
@RequestMapping("/manage")
public class ProductController extends AdminBaseController {

    @Value("${upload.attached.ext.image}")
    private String uploadAttachedExtImage;
    @Value("${upload.attached.path}")
    private String uploadAttachedPath;
    @Value("${upload.attached.url}")
    private String uploadAttachedUrl;
    @Value("${upload.attached.maxsize}")
    private long uploadAttachedMaxsize;
    @Resource
    private ProductWrapService productWrapService;
    @Resource
    private ProductTypeWrapService productTypeWrapService;

    @RequestMapping(value = "/product")
    public ModelAndView product(HttpServletRequest request, PageBean pageBean, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        ProductParam productParam = new ProductParam();
        productParam.setPageBean(pageBean);
        productParam.setOrderView("id desc");
        List<Product> productList;
        Map<Integer, ProductType> productTypeMap = new HashMap<>();
        try {
            productList = productWrapService.selectProduct(productParam);
            pageBean.setTotal(productWrapService.countProduct(productParam));
            pageBean.compute();
            Set<Integer> productTypeIdSet = new HashSet<>();
            for (Product product : productList) {
                productTypeIdSet.add(product.getProductType());
            }
            if (!productTypeIdSet.isEmpty()) {
                ProductTypeParam productTypeParam = new ProductTypeParam();
                productTypeParam.setProductTypeIdCollection(productTypeIdSet);
                List<ProductType> productTypeList = productTypeWrapService.selectProductType(productTypeParam);
                for (ProductType productType : productTypeList) {
                    productTypeMap.put(productType.getId(), productType);
                }
            }
        } catch (Exception e) {
            productList = Collections.emptyList();
            logger.error(e.getMessage(), e);
        }

        Map<String, Object> model = new HashMap<>();
        model.put(Constant.IMPORT_MAIN, Constant.IMPORT_PRODUCT);
        model.put(Constant.NAV_ACTIVE, Constant.NAV_ACTIVE_PRODUCT);
        model.put("productList", productList);
        model.put("productTypeMap", productTypeMap);
        model.put("pageBean", pageBean);

        return new ModelAndView(Constant.VIEW_MAIN, model);
    }

    @RequestMapping(value = "/product/input")
    public ModelAndView productInput(HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        String productTypeName = "";
        Product product = productWrapService.getProduct(id);
        if (product != null) {
            Integer productTypeId = product.getProductType();
            ProductType productType = productTypeWrapService.getProductType(productTypeId);
            if (productType != null) {
                productTypeName = productType.getName();
            }
        }

        Map<String, Object> model = new HashMap<>();
        model.put(Constant.IMPORT_MAIN, Constant.IMPORT_PRODUCT_INPUT);
        model.put(Constant.NAV_ACTIVE, Constant.NAV_ACTIVE_PRODUCT);
        model.put("product", product);
        model.put("productTypeName", productTypeName);

        return new ModelAndView(Constant.VIEW_MAIN, model);
    }

    @RequestMapping(value = "/product/manage")
    public ModelAndView productManage(HttpServletRequest request, @Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        try {
            checkError(bindingResult);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_PRODUCT);
        }

        Integer id = product.getId();
        if (id == null) {
            productWrapService.insertProduct(product);
        } else {
            ProductParam productParam = new ProductParam();
            productParam.setId(id);
            productParam.setUpdateProduct(product);
            productWrapService.updateProduct(productParam);
        }

        return CodeTool.redirect(Constant.REDIRECT_PRODUCT);
    }

    @RequestMapping(value = "/product/delete")
    public ModelAndView productDelete(HttpServletRequest request, @RequestParam("id") Integer id, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        ProductParam productParam = new ProductParam();
        productParam.setId(id);
        productWrapService.deleteProduct(productParam);

        return CodeTool.redirect(Constant.REDIRECT_PRODUCT);
    }

    @RequestMapping(value = "/product/upload")
    public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            write(response, CodeTool.toJsonString(e.getResultMessage()));
            return;
        }

        if (!ServletFileUpload.isMultipartContent(request)) {
            write(response, CodeTool.toJsonString(new ResultMessage(Constant.CODE_FAILURE, "请选择文件")));
            return;
        }

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding(Constant.UTF_8);
        List items = upload.parseRequest(request);
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            FileItem item = (FileItem) iterator.next();
            if (!item.isFormField()) {
                //检查文件大小
                if (item.getSize() > uploadAttachedMaxsize) {
                    write(response, CodeTool.toJsonString(new ResultMessage(Constant.CODE_FAILURE, "上传文件大小超过限制")));
                    return;
                }
                //检查扩展名
                String fileName = item.getName();
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                if (!uploadAttachedExtImage.contains(fileExt)) {
                    write(response, CodeTool.toJsonString(new ResultMessage(Constant.CODE_FAILURE, "上传文件扩展名是不允许的扩展名。\n只允许" + uploadAttachedExtImage + "格式。")));
                    return;
                }

                String dir = new SimpleDateFormat("MM").format(new Date());

                String newFileName = CodeTool.encodeMD5(fileName + "_" + System.currentTimeMillis()) + "." + fileExt;
                try {
                    File uploadDir = new File(uploadAttachedPath, dir);
                    uploadDir.mkdirs();
                    item.write(new File(uploadDir, newFileName));
                } catch (Exception e) {
                    write(response, CodeTool.toJsonString(new ResultMessage(Constant.CODE_FAILURE, "上传文件失败。")));
                    return;
                }

                write(response, CodeTool.toJsonString(new ResultMessage(Constant.CODE_SUCCESS, uploadAttachedUrl + "/" + dir + "/" + newFileName)));
                return;
            }
        }
        write(response, CodeTool.toJsonString(new ResultMessage(Constant.CODE_FAILURE, "上传文件丢失。")));
    }

}
