'use strict';

/**
 * 初始化
 * */
$(function ($) {
    let mainProcess = new MainProcess();

    mainProcess.main();
});

/**
 * 主要过程类
 * */
class MainProcess {
    uiProceed = new UiProceed();

    /**
     * 主要过程
     */
    main() {
        this.start();
    }

    /**
     * 页面加载后执行
     */
    start() {
        this.uiProceed.initUi();
    }
}

class UiProceed {
    vueNavPanel;
    vueUserPanel;
    vueResultInfoPanel;

    initUi() {
        this.initUiParam();
        this.initUiController();
    }

    initUiParam() {

    }

    initUiController() {
        let _this = this;

        // 选项卡控件
        this.vueNavPanel = new Vue({
            el: "#navPanel",
            data: {
                method: METHOD_LOGIN
            },
            methods: {
                changeToLogin: function () {
                    this.method = METHOD_LOGIN;
                    _this.vueUserPanel.method = this.method;
                },
                changeToReg: function () {
                    this.method = METHOD_REG;
                    _this.vueUserPanel.method = this.method;
                }
            }
        });

        // 用户表单控件
        this.vueUserPanel = new Vue({
            el: "#userPanel",
            data: {
                method: METHOD_LOGIN,
                userVo: new UserVo(),
                showPassword: false,
                captchaUrl: `${WEB_ROOT}/Captcha?action=get&${Math.random()}`
            },
            methods: {
                refreshCaptcha: function () {
                    this.captchaUrl = `${WEB_ROOT}/Captcha?action=get&${Math.random()}`;
                },
                toggleShowPassword: function() {
                    this.showPassword = !this.showPassword;
                },
                login: function () {
                    _this.login(this.userVo);
                },
                reg: function () {
                    _this.reg(this.userVo);
                }
            }
        });

        // 响应结果控件
        this.vueResultInfoPanel = new Vue({
            el: "#resultInfoPanel",
            data: {
                resultInfo: new ResultInfo(),
                show: false
            },
            methods: {
                showResultInfo: function () {
                    this.show = true;

                    window.setTimeout(() => {
                        this.show = false;
                    }, 3000);
                }
            },
        });
    }

    // 登录
    login(userVo) {
        let userProceed = new UserProceed();

        userVo.type = 0;
        userVo.password = md5(userVo.password);
        userProceed.login(userVo, (resultInfo) => {
            this.vueResultInfoPanel.resultInfo = resultInfo;
            this.vueResultInfoPanel.showResultInfo();
            this.vueUserPanel.refreshCaptcha();

            if (resultInfo.success) {
                new CookieProceed().addCookie("user", resultInfo.resultData, 3);
                location.href = "./admin_management.html";
            }
        });
    }

    // 注册
    reg(userVo) {
        let userProceed = new UserProceed();

        userVo.type = 0;
        userVo.password = md5(userVo.password);
        userProceed.reg(userVo, (resultInfo) => {
            this.vueResultInfoPanel.resultInfo = resultInfo;
            this.vueResultInfoPanel.showResultInfo();
            this.vueUserPanel.refreshCaptcha();

            if (resultInfo.success) {
                new CookieProceed().addCookie("user", resultInfo.resultData, 3);
                location.href = "./admin_management.html";
            }
        });
    }
}
