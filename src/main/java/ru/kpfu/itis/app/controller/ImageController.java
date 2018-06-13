package ru.kpfu.itis.app.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class ImageController {

    @ResponseBody
    @GetMapping(value = "/image/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("name") String name) {
        try {
            InputStream in = getClass().getResourceAsStream("src/main/resources/images/uploaded/" + name);
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @PostMapping("/image-load")
    public ResponseEntity loadImage(@RequestAttribute("image") MultipartFile image) {
        String result = "none";
        if (image != null && !image.isEmpty()) {
            try {
                byte[] bytes = image.getBytes();
                File file = new File("src/main/resources/images/uploaded/" + image.getOriginalFilename().split("\\.")[0]);
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(file));
                stream.write(bytes);
                stream.close();
                result = image.getOriginalFilename().split("\\.")[0];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.ok(result);
    }
}
