package com.hk.shop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.shop.vo.EventVO;


@Controller
public class FileDownController {

   //파일다운로드
   @RequestMapping(value="/fileDownload")
   public void fileDownload(HttpServletRequest request, HttpServletResponse response,@RequestParam("eventImg")String eventImg) throws Exception {
      
      String fileName = eventImg;
      String realFileName="";
      System.out.println("fileName="+fileName);
      
      String browser = request.getHeader("User-Agent");
      //파일인코딩
      if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
         fileName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
         
      } else {
         fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
      }
      realFileName = "C:\\board\\eventImg\\"+fileName;
      System.out.println("realFileName="+ realFileName);
      File file1 = new File(realFileName);
      if (!file1.exists()) {
         return ;
      }
      
      //파일명 지정
      response.setContentType("application/octer-stream");
      response.setHeader("Content-Transfer-Encoding", "binary");
      response.setHeader("content-Disposition", "attachment; fileName=\""+fileName+"\"");
      
      
      OutputStream os = response.getOutputStream();
      FileInputStream fis = new FileInputStream(realFileName);
      
      int ncount = 0;
      byte[] bytes = new byte[512];
      
      while ((ncount = fis.read(bytes)) != -1) {
         os.write(bytes,0,ncount);
      }
      fis.close();
      os.close();
      
      
   }
   
   @RequestMapping(value="/fileDownloadPro")
   public void fileDownloadPro(HttpServletRequest request, HttpServletResponse response,@RequestParam("topImage")String topImage) throws Exception {
      
      String fileName = topImage;
      String realFileName="";
      System.out.println("fileName="+fileName);
      
      String browser = request.getHeader("User-Agent");
      //파일인코딩
      if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
         fileName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
         
      } else {
         fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
      }
      realFileName = "c:\\board\\productImg\\productImg"+fileName;
      System.out.println("realFileName="+ realFileName);
      File file1 = new File(realFileName);
      if (!file1.exists()) {
         return ;
      }
      
      //파일명 지정
      response.setContentType("application/octer-stream");
      response.setHeader("Content-Transfer-Encoding", "binary");
      response.setHeader("content-Disposition", "attachment; fileName=\""+fileName+"\"");
      
      
      OutputStream os = response.getOutputStream();
      FileInputStream fis = new FileInputStream(realFileName);
      
      int ncount = 0;
      byte[] bytes = new byte[512];
      
      while ((ncount = fis.read(bytes)) != -1) {
         os.write(bytes,0,ncount);
      }
      fis.close();
      os.close();
      
      
   }
   
}