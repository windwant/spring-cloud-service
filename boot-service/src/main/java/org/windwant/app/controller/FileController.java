package org.windwant.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 18-8-10.
 */
@Controller
public class FileController {

    @RequestMapping("/upload")
    public String fileUpload(MultipartRequest request){
        System.out.println(request.getFile("file").getName());
        try {
            request.getFile("file").transferTo(new File("d:\\abc.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "file";
    }
}
