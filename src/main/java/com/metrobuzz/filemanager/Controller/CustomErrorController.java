package com.metrobuzz.filemanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.metrobuzz.filemanager.Utils.ApiResponse;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ApiResponse handleError(HttpServletRequest request, Model model) {

        // Get error details from ErrorAttributes
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(
                getRequestAttributes(request), ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE));

        String pathMessage = errorDetails.containsKey("path")
                ? String.format(" Error occurred on path - %s", errorDetails.get("path"))
                : "";

        String responseMessage = String.format("Unable to proceed with your request - %s", errorDetails.get("error"))
                + pathMessage;

        int code = (int) errorDetails.get("status");

        // Provide logic to redirect or show a custom error page
        return ApiResponse.error(responseMessage.toLowerCase(), code, null);
    }

    private WebRequest getRequestAttributes(HttpServletRequest request) {
        return new ServletWebRequest(request);
    }
}
