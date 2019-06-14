package tyfanch.electivehelper.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import tyfanch.electivehelper.view.proceed.CaptchaProceed;

@WebServlet(name = "CaptchaServlet", urlPatterns = {"/Captcha"})
public class CaptchaServlet extends CommonServlet {
    public void get(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        HttpSession session = request.getSession();
        CaptchaProceed captchaProceed = new CaptchaProceed();
        String captcha;
        BufferedImage captchaImage;
        ServletOutputStream outputStream;

        captcha = captchaProceed.newCaptcha();
        captchaProceed.storeCaptcha(session, captcha);
        captchaImage = captchaProceed.generateCaptchaImage(captcha);
        System.out.println("---- captchaGet: " + captcha);

        try {
            outputStream = response.getOutputStream();
            ImageIO.write(captchaImage, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证码生成
     *
     * @param request 请求
     * @param response 响应
     * @return 生成的验证码
     */
    private String getText(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        HttpSession session = request.getSession();
        CaptchaProceed captchaProceed = new CaptchaProceed();
        String captchaText;
        PrintWriter writer;

        captchaText = captchaProceed.newCaptcha();
        captchaProceed.storeCaptcha(session, captchaText);
        System.out.println("---- getText: " + captchaText);

        try {
            writer = response.getWriter();
            writer.write(captchaText);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return captchaText;
    }
}
