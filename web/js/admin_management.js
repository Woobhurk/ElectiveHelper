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
 */
class MainProcess {
    uiProceed = new UiProceed();

    main() {
        this.start();
    }

    start() {
        this.uiProceed.initUi();
    }
}


/**
 * 界面处理类
 */
class UiProceed {
    tabNames = new Array(INDEX_TOTAL_COUNT);
    queryVos = new Array(INDEX_TOTAL_COUNT);
    queryVoConsts = new Array(INDEX_TOTAL_COUNT);
    updateVos = new Array(INDEX_TOTAL_COUNT);
    updateVoConsts = new Array(INDEX_TOTAL_COUNT);

    vueNavPanel;
    vueConditionPanel;
    vueInfoPanel;
    vueDataListPanel;
    vuePagePanel;

    initUi() {
        this.initUiParam();
        this.initUiController();
        //this.inflateWidget();
        //this.bindWidgetEvent();
        //this.initWidget();
        this.refreshWidget();
    }

    /**
     * 初始化控件参数
     */
    initUiParam() {
        let queryVoConst;

        this.tabNames[INDEX_USER] = "用户";
        this.tabNames[INDEX_USER_TYPE] = "用户类型";
        this.tabNames[INDEX_MSG] = "聊天记录";
        this.tabNames[INDEX_COURSE] = "课程";
        this.tabNames[INDEX_REPLY] = "评论";
        this.tabNames[INDEX_CLASSROOM] = "教室";
        this.tabNames[INDEX_STUDENT] = "学生";
        this.tabNames[INDEX_TEACHER] = "老师";
        this.tabNames[INDEX_STUDENT_COURSE] = "学生选课";

        this.queryVos[INDEX_USER] = new UserQueryVo();
        this.queryVos[INDEX_USER_TYPE] = new UserTypeQueryVo();
        this.queryVos[INDEX_MSG] = new MsgQueryVo();
        this.queryVos[INDEX_COURSE] = new CourseQueryVo();
        this.queryVos[INDEX_REPLY] = new ReplyQueryVo();
        this.queryVos[INDEX_CLASSROOM] = new ClassroomQueryVo();
        this.queryVos[INDEX_STUDENT] = new StudentQueryVo();
        this.queryVos[INDEX_TEACHER] = new TeacherQueryVo();
        this.queryVos[INDEX_STUDENT_COURSE] = new StudentCourseQueryVo();

        this.queryVoConsts[INDEX_USER] = new UserQueryVoConst();
        this.queryVoConsts[INDEX_USER_TYPE] = new UserTypeQueryVoConst();
        this.queryVoConsts[INDEX_MSG] = new MsgQueryVoConst();
        this.queryVoConsts[INDEX_COURSE] = new CourseQueryVoConst();
        this.queryVoConsts[INDEX_REPLY] = new ReplyQueryVoConst();
        this.queryVoConsts[INDEX_CLASSROOM] = new ClassroomQueryVoConst();
        this.queryVoConsts[INDEX_STUDENT] = new StudentQueryVoConst();
        this.queryVoConsts[INDEX_TEACHER] = new TeacherQueryVoConst();
        this.queryVoConsts[INDEX_STUDENT_COURSE] = new StudentCourseQueryVoConst();

        //// 使用循环初始化所有列表的查询条件
        //for (let i = 0; i < INDEX_TOTAL_COUNT; i++) {
        //    this.queryVos[i] = {
        //        queryMethod: this.queryVoConsts[i].QUERY_BY_COLUMN,
        //        columns: [this.queryVoConsts[i].COLUMN_NAMES.ID[0]],
        //        compares: [this.queryVoConsts[i].COMPARE_NAMES.GT[0]],
        //        values: ["-1"],
        //        connectors: []
        //    };
        //}

        this.updateVos[INDEX_USER] = new UserUpdateVo();
        this.updateVos[INDEX_USER_TYPE] = new UserTypeUpdateVo();
        this.updateVos[INDEX_MSG] = new MsgUpdateVo();
        this.updateVos[INDEX_COURSE] = new CourseUpdateVo();
        this.updateVos[INDEX_REPLY] = new ReplyUpdateVo();
        this.updateVos[INDEX_CLASSROOM] = new ClassroomUpdateVo();
        this.updateVos[INDEX_STUDENT] = new StudentUpdateVo();
        this.updateVos[INDEX_TEACHER] = new TeacherUpdateVo();
        this.updateVos[INDEX_STUDENT_COURSE] = new StudentCourseUpdateVo();

        this.updateVoConsts[INDEX_USER] = new UserUpdateVoConst();
        this.updateVoConsts[INDEX_USER_TYPE] = new UserTypeUpdateVoConst();
        this.updateVoConsts[INDEX_MSG] = new MsgUpdateVoConst();
        this.updateVoConsts[INDEX_COURSE] = new CourseUpdateVoConst();
        this.updateVoConsts[INDEX_REPLY] = new ReplyUpdateVoConst();
        this.updateVoConsts[INDEX_CLASSROOM] = new ClassroomUpdateVoConst();
        this.updateVoConsts[INDEX_STUDENT] = new StudentUpdateVoConst();
        this.updateVoConsts[INDEX_TEACHER] = new TeacherUpdateVoConst();
        this.updateVoConsts[INDEX_STUDENT_COURSE] = new StudentCourseUpdateVoConst();

        //for (let i = 0; i < INDEX_TOTAL_COUNT; i++) {
        //    this.updateVos[i] = {
        //        updateColumns
        //    };
        //}

        // 单独设置每一个列表的查询条件
        queryVoConst = new UserQueryVoConst();
        this.queryVos[INDEX_USER].columns = [queryVoConst.COLUMN_NAMES.username[0]];
        this.queryVos[INDEX_USER].compares = [queryVoConst.COMPARE_NAMES.like[0]];
        this.queryVos[INDEX_USER].values = ["%a%"];
        this.queryVos[INDEX_USER].connectors = [];

        queryVoConst = new UserTypeQueryVoConst();
        this.queryVos[INDEX_USER_TYPE].columns = [queryVoConst.COLUMN_NAMES.id[0]];
        this.queryVos[INDEX_USER_TYPE].compares = [queryVoConst.COMPARE_NAMES.gt[0]];
        this.queryVos[INDEX_USER_TYPE].values = ["-1"];
        this.queryVos[INDEX_USER_TYPE].connectors = [];

        queryVoConst = new MsgQueryVoConst();
        this.queryVos[INDEX_MSG].columns = [queryVoConst.COLUMN_NAMES.senderId[0]];
        this.queryVos[INDEX_MSG].compares = [queryVoConst.COMPARE_NAMES.gt[0]];
        this.queryVos[INDEX_MSG].values = ["2"];
        this.queryVos[INDEX_MSG].connectors = [];

        queryVoConst = new CourseQueryVoConst();
        this.queryVos[INDEX_COURSE].columns = [queryVoConst.COLUMN_NAMES.id[0]];
        this.queryVos[INDEX_COURSE].compares = [queryVoConst.COMPARE_NAMES.gt[0]];
        this.queryVos[INDEX_COURSE].values = ["-1"];
        this.queryVos[INDEX_COURSE].connectors = [];

        queryVoConst = new ReplyQueryVoConst();
        this.queryVos[INDEX_REPLY].columns = [queryVoConst.COLUMN_NAMES.senderId[0]];
        this.queryVos[INDEX_REPLY].compares = [queryVoConst.COMPARE_NAMES.lt[0]];
        this.queryVos[INDEX_REPLY].values = ["20"];
        this.queryVos[INDEX_REPLY].connectors = [];

        queryVoConst = new ClassroomQueryVoConst();
        this.queryVos[INDEX_CLASSROOM].columns = [queryVoConst.COLUMN_NAMES.room[0]];
        this.queryVos[INDEX_CLASSROOM].compares = [queryVoConst.COMPARE_NAMES.like[0]];
        this.queryVos[INDEX_CLASSROOM].values = ["%8"];
        this.queryVos[INDEX_CLASSROOM].connectors = [];

        queryVoConst = new StudentQueryVoConst();
        this.queryVos[INDEX_STUDENT].columns = [queryVoConst.COLUMN_NAMES.id[0]];
        this.queryVos[INDEX_STUDENT].compares = [queryVoConst.COMPARE_NAMES.gt[0]];
        this.queryVos[INDEX_STUDENT].values = ["-1"];
        this.queryVos[INDEX_STUDENT].connectors = [];

        queryVoConst = new TeacherQueryVoConst();
        this.queryVos[INDEX_TEACHER].columns = [queryVoConst.COLUMN_NAMES.id[0]];
        this.queryVos[INDEX_TEACHER].compares = [queryVoConst.COMPARE_NAMES.gt[0]];
        this.queryVos[INDEX_TEACHER].values = ["-1"];
        this.queryVos[INDEX_TEACHER].connectors = [];

        queryVoConst = new StudentCourseQueryVoConst();
        this.queryVos[INDEX_STUDENT_COURSE].columns = [queryVoConst.COLUMN_NAMES.id[0]];
        this.queryVos[INDEX_STUDENT_COURSE].compares = [queryVoConst.COMPARE_NAMES.gt[0]];
        this.queryVos[INDEX_STUDENT_COURSE].values = ["-1"];
        this.queryVos[INDEX_STUDENT_COURSE].connectors = [];
    }

    /**
     * 初始化控件控制器
     */
    initUiController() {
        const _this = this;

        // 导航控件
        this.vueNavPanel = new Vue({
            el: "#navPanel",
            data: {
                tabNames: _this.tabNames,
            },
            methods: {
                // 切换了选项卡就要刷新所有控件
                refreshPanels: function (index) {
                    _this.vueConditionPanel.queryVo = _this.queryVos[index];
                    _this.vueConditionPanel.queryVoConst = _this.queryVoConsts[index];
                    _this.vueDataListPanel.queryVoConst = _this.queryVoConsts[index];
                    _this.vueDataListPanel.updateVo = _this.updateVos[index];
                    _this.vueDataListPanel.updateVoConst = _this.updateVoConsts[index];
                    _this.vueDataListPanel.selectedIndex = 0;
                    _this.vuePagePanel.pageOffset = 1;
                    _this.refreshDataList();
                }
            }
        });

        // 查询条件控件
        this.vueConditionPanel = new Vue({
            el: "#conditionPanel",
            data: {
                queryVo: _this.queryVos[INDEX_USER],
                queryVoConst: _this.queryVoConsts[INDEX_USER]
            },
            methods: {
                // 删除查询条件
                removeCondition: function (index) {
                    this.queryVo.columns.splice(index, 1);
                    this.queryVo.compares.splice(index, 1);
                    this.queryVo.values.splice(index, 1);

                    // 如果当前条件下标不超过连接词长度则删除连接词
                    if (index < this.queryVo.connectors.length - 1) {
                        this.queryVo.connectors.splice(index, 1);
                    }

                    // 删除条件之后自动重新查找
                    _this.refreshDataList();
                },
                addCondition: function () {
                    // 增加查询条件
                    this.queryVo.columns.push(this.queryVoConst.COLUMN_NAMES.id[0]);
                    this.queryVo.compares.push(this.queryVoConst.COMPARE_NAMES.gt[0]);
                    this.queryVo.values.push("-1");
                    this.queryVo.connectors.push(this.queryVoConst.CONNECTOR_NAMES.and[0]);
                    //_this.refreshDataList();
                },
                query: function () {
                    // 查询，即刷新列表
                    _this.refreshDataList();
                }
            }
        });

        // 信息控件
        this.vueInfoPanel = new Vue({
            el: "#infoPanel",
            data: {
                resultInfo: {},
                resultInfoConst: new ResultInfoConst()
            }
        });

        // 数据列表控件
        this.vueDataListPanel = new Vue({
            el: "#dataListPanel",
            data: {
                queryVoConst: _this.queryVoConsts[INDEX_USER],
                updateVo: _this.updateVos[INDEX_USER],
                updateVoConst: _this.updateVoConsts[INDEX_USER],
                dataList: [],
                selectedIndex: 0,
                selectedData: {},
                updateMode: true
            },
            methods: {
                // 点击列表项，选择数据，变成编辑模式
                selectData: function (index) {
                    this.selectedData = this.dataList[index];
                    this.selectedIndex = index;
                    this.updateMode = true;
                },
                // 点击新增按钮，右方编辑区清空，变为插入模式
                insertData: function () {
                    // 点击新增按钮则打开插入模式
                    if (this.updateMode) {
                        this.selectedData = {};
                        this.updateMode = false;

                        for (let key in this.dataList[0]) {
                            this.selectedData[key] = null;
                        }
                    } else {
                        // 插入模式打开后点击插入按钮则插入数据
                        _this.insertData(this.selectedData);
                        this.selectedData = this.dataList[0];
                        this.updateMode = true;
                    }
                },
                // 删除数据
                deleteData: function (index) {
                    let id = this.dataList[index].id;

                    _this.deleteData(id);
                },
                // 修改数据
                updateData: function () {
                    let data = this.selectedData;

                    _this.updateData(data);
                }
            }
        });

        // 分页控件
        this.vuePagePanel = new Vue({
            el: "#pagePanel",
            data: {
                pageOffset: 1,
                pageCount: 0,
                dataCountList: [5, 10, 15, 20, 50, 100, 0],
                dataCount: 10,
                dataAllCount: 0
            },
            methods: {
                // 修改页码
                changePageOffset: function () {
                    if (this.pageOffset < 1) {
                        this.pageOffset = 1;
                    } else if (this.pageOffset > this.pageCount) {
                        this.pageOffset = this.pageCount;
                    }

                    _this.refreshDataList();
                },
                // 上一页
                prevPage: function () {
                    if (this.pageOffset > 1) {
                        this.pageOffset--;
                    }

                    _this.refreshDataList();
                },
                // 下一页
                nextPage: function () {
                    if (this.pageOffset < this.pageCount) {
                        this.pageOffset++;
                    }

                    _this.refreshDataList();
                },
                // 修改每页显示数量
                changeDataCount: function () {
                    _this.refreshDataList();
                }
            }
        });
    }

    inflateWidget() {
    }

    bindWidgetEvent() {
        this.bindNavWidgetEvent();
        this.bindQueryWidgetEvent();
    }

    initWidget() {
        this.initDataList();
    }

    refreshWidget() {
        this.refreshQueryWidget();
        this.refreshDataList();
    }

    bindNavWidgetEvent() {
    }

    bindQueryWidgetEvent() {
    }

    refreshQueryWidget() {
    }

    initDataList() {

    }

    refreshDataList() {
        let adminService = new AdminService();
        let userJson = new CookieProceed().getCookie("user");
        let queryVo = this.vueConditionPanel.queryVo;
        let vueDataList = this.vueDataListPanel;
        let vuePage = this.vuePagePanel;

        // 计算总页数
        adminService.queryAllCount(userJson, queryVo, function (resultInfo) {
            let dataAllCount = resultInfo.resultData;

            vuePage.dataAllCount = dataAllCount;

            if (vuePage.dataCount > 0) {
                // 如果每页显示数量大于零则计算页数
                vuePage.pageCount = Math.ceil(dataAllCount / vuePage.dataCount);
            } else {
                // 每页数量为0（即显示全部），则页数为1
                vuePage.pageCount = 1;
            }

            // 判断页数更新后当前页码是否超出范围
            if (vuePage.pageOffset > vuePage.pageCount) {
                vuePage.pageOffset = vuePage.pageCount;
            }
        });

        // 查询数据的页码数是0开始的，所以要-1
        queryVo.pageOffset = vuePage.pageOffset - 1;
        queryVo.recordCount = vuePage.dataCount;
        // 查询数据
        adminService.query(userJson, queryVo, (resultInfo) => {
            if (!resultInfo.success) {
                location.href = "./index.html";
            }

            // 更新数据列表
            vueDataList.dataList = JSON.parse(resultInfo.resultData);
            // 更新选择的数据
            vueDataList.selectedData = vueDataList.dataList[vueDataList.selectedIndex];
            //this.vueInfoPanel.resultInfo = resultInfo;
        });
    }

    insertData(newData) {
        let adminService = new AdminService();
        let vueDataList = this.vueDataListPanel;
        let userJson = new CookieProceed().getCookie("user");
        let updateVo = vueDataList.updateVo;
        let updateVoConst = vueDataList.updateVoConst;

        newData.id = null;

        // 将新增的数据的值存入updateVo
        for (let columnName in updateVoConst.COLUMN_NAMES) {
            updateVo.updateColumns.push(updateVoConst.COLUMN_NAMES[columnName][0]);
            updateVo.updateValues.push(newData[updateVoConst.COLUMN_NAMES[columnName][0]]);
        }

        adminService.insert(userJson, updateVo, (resultInfo) => {
            if (!resultInfo.success) {
                location.href = "./index.html";
            }

            this.vueInfoPanel.resultInfo = resultInfo;
            this.refreshDataList();
        });
    }

    deleteData(id) {
        let adminService = new AdminService();
        let vueDataList = this.vueDataListPanel;
        let userJson = new CookieProceed().getCookie("user");
        let updateVo = vueDataList.updateVo;
        let updateVoConst = vueDataList.updateVoConst;

        // 将要删除的id存入updateVo
        updateVo.columns = [updateVoConst.COLUMN_NAMES.id[0]];
        updateVo.compares = [updateVoConst.COMPARE_NAMES.eq[0]];
        updateVo.values = [id];
        adminService.delete(userJson, updateVo, (resultInfo) => {
            if (!resultInfo.success) {
                location.href = "./index.html";
            }

            this.vueInfoPanel.resultInfo = resultInfo;
            this.refreshDataList();
        });
    }

    updateData(data) {
        let adminService = new AdminService();
        let vueDataList = this.vueDataListPanel;
        let userJson = new CookieProceed().getCookie("user");
        let updateVo = vueDataList.updateVo;
        let updateVoConst = vueDataList.updateVoConst;

        updateVo.columns = [updateVoConst.COLUMN_NAMES.id[0]];
        updateVo.compares = [updateVoConst.COMPARE_NAMES.eq[0]];
        updateVo.values = [data.id];

        // 将修改之后的值存入updateVo
        for (let columnName in updateVoConst.COLUMN_NAMES) {
            updateVo.updateColumns.push(updateVoConst.COLUMN_NAMES[columnName][0]);
            updateVo.updateValues.push(data[updateVoConst.COLUMN_NAMES[columnName][0]]);
        }

        adminService.update(userJson, updateVo, (resultInfo) => {
            if (!resultInfo.success) {
                location.href = "./index.html";
            }

            this.vueInfoPanel.resultInfo = resultInfo;
            this.refreshDataList();
        });
    }
}
