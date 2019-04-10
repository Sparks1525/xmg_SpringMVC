package my.demo.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

public class FileController {
    @RequestMapping("/down")
    @ResponseBody//添加这样的注解,告诉springMVC所有的响应都由response操作
    public void download(HttpServletResponse response){
        File file = new File("F:/lanxw/springMVC/a.jpg");
        //定义输入流
        FileInputStream fis = null;
        try{
            response.setHeader("Content-Disposition", "attachment;filename=a.jpg");
            fis = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            IOUtils.copy(fis, outputStream);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }




    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        System.out.println(file.getContentType());//文件类型
        //file.getInputStream();//把前台的文件变成inputstream;
        System.out.println(file.getName());//前台传入的名字
        System.out.println(file.getOriginalFilename());//原始名字
        System.out.println(file.getSize());
        //将上传的文件保存在服务器中
        String dir = "F:/lanxw/file";
        FileOutputStream fileOutputStream =null;
        try {
            InputStream inputStream = file.getInputStream();
            String uuid= UUID.randomUUID().toString();
            String lastName = file.getOriginalFilename().split("\\.")[1];
            String fileName = uuid+"."+lastName;
            fileOutputStream = new FileOutputStream(new File(dir,fileName));
            IOUtils.copy(inputStream, fileOutputStream);
            //对上传名称做对应的处理
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:upload.jsp";
    }
}
