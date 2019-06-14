package tyfanch.electivehelper.view.proceed;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Random;
import tyfanch.electivehelper.view.vo.CaptchaConst;

/**
 * 验证码处理类
 */
public class CaptchaProceed {
    /**
     * 存储验证码
     *
     * @param session 当前会话
     * @param captcha 要存储的验证码
     */
    public void storeCaptcha(HttpSession session, String captcha) {
        session.setAttribute(CaptchaConst.NAME, captcha);
    }

    /**
     * 获取已存储的验证码
     *
     * @param session 当前会话
     * @return 已存储的验证码
     */
    public String loadCaptcha(HttpSession session) {
        String captcha;

        captcha = (String) session.getAttribute(CaptchaConst.NAME);

        return captcha;
    }

    /**
     * 检验验证码
     *
     * @param session 当前会话
     * @param captcha 要检验的验证码
     * @return 检验结果
     */
    public boolean checkCaptcha(HttpSession session, String captcha) {
        String storedCaptcha = this.loadCaptcha(session);

        return captcha.equalsIgnoreCase(storedCaptcha);
    }

    /**
     * 生成新的验证码
     *
     * @return 生成的新验证码
     */
    public String newCaptcha() {
        return this.generateCaptchaText(CaptchaConst.CAPTCHA_LENGTH);
    }

    /**
     * 根据验证码生成验证码图像
     *
     * @param captcha 验证码
     * @return 验证码图像
     */
    public BufferedImage generateCaptchaImage(String captcha) {
        CaptchaImageProceed captchaImageProceed = new CaptchaImageProceed();
        BufferedImage bufferedImage;

        bufferedImage = captchaImageProceed.generateCaptchaImage(CaptchaConst.CAPTCHA_WIDTH,
            CaptchaConst.CAPTCHA_HEIGHT, captcha);

        return bufferedImage;
    }

    /**
     * 生成验证码
     *
     * @param length 验证码长度
     * @return 生成的验证码
     */
    public String generateCaptchaText(int length) {
        StringBuilder captchaSb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            captchaSb.append(this.generateRandomChar());
        }

        return captchaSb.toString();
    }

    /**
     * 生成随机字符
     *
     * @return 随机的字符
     */
    private char generateRandomChar() {
        Random random = new Random();
        char result;

        // 字母和数字随机
        if (random.nextInt(2) == 0) {
            result = (char) ('0' + random.nextInt('9' - '0' + 1));
        } else {
            result = (char) ('A' + random.nextInt('Z' - 'A' + 1));
        }

        return result;
    }
}
