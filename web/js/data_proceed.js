class AdminService {
    query(userJson, queryVo, onResult) {
        let queryVoJson;

        queryVo.queryMethod = new QueryVoConst().QUERY_BY_COLUMN;
        queryVoJson = JSON.stringify(queryVo);

        $.post(`${WEB_ROOT}/Admin`, {
            action: "queryTable",
            user: userJson,
            queryVo: queryVoJson
        }, (resultInfo) => {
            onResult(resultInfo);
        }, "json");
    }

    queryAllCount(userJson, queryVo, onResult) {
        let queryVoJson;

        queryVo.queryMethod = new QueryVoConst().QUERY_ALL_COUNT;
        queryVoJson = JSON.stringify(queryVo);

        $.post(`${WEB_ROOT}/Admin`, {
            action: "queryTable",
            user: userJson,
            queryVo: queryVoJson
        }, (resultInfo) => {
            onResult(resultInfo);
        }, "json");
    }

    insert(userJson, updateVo, onResult) {
        let updateVoJson;

        updateVo.updateMethod = new UpdateVoConst().UPDATE_INSERT;
        updateVoJson = JSON.stringify(updateVo);

        $.post(`${WEB_ROOT}/Admin`, {
            action: "updateTable",
            user: userJson,
            updateVo: updateVoJson
        }, (resultInfo) => {
            onResult(resultInfo);
        }, "json");
    }

    delete(userJson, updateVo, onResult) {
        let updateVoJson;

        updateVo.updateMethod = new UpdateVoConst().UPDATE_DELETE;
        updateVoJson = JSON.stringify(updateVo);

        $.post(`${WEB_ROOT}/Admin`, {
            action: "updateTable",
            user: userJson,
            updateVo: updateVoJson
        }, (resultInfo) => {
            onResult(resultInfo);
        }, "json");
    }

    update(userJson, updateVo, onResult) {
        let updateVoJson;

        updateVo.updateMethod = new UpdateVoConst().UPDATE_MODIFY;
        updateVoJson = JSON.stringify(updateVo);

        $.post(`${WEB_ROOT}/Admin`, {
            action: "updateTable",
            user: userJson,
            updateVo: updateVoJson
        }, (resultInfo) => {
            onResult(resultInfo);
        }, "json");
    }
}

class UserProceed {
    login(userVo, onResult) {
        let userVoJson;

        userVoJson = window.btoa(JSON.stringify(userVo));

        $.post(`${WEB_ROOT}/Admin`, {
            action: "login",
            userVo: userVoJson
        }, (resultInfo) => {
            onResult(resultInfo);
        }, "json");
    }

    reg(userVo, onResult) {
        let userVoJson;

        userVoJson = window.btoa(JSON.stringify(userVo));

        $.post(`${WEB_ROOT}/Admin`, {
            action: "reg",
            userVo: userVoJson
        }, (resultInfo) => {
            onResult(resultInfo);
        }, "json");
    }
}

class ResultInfoProceed {

}

class CookieProceed {
    addCookie(name, value, expireDay) {
        let expireDate = new Date();

        expireDate.setDate(expireDate.getDate() + expireDay);
        document.cookie = `${name}=${value};expires=${expireDate.toUTCString()}`;
    }

    getCookie(name) {
        let cookies = document.cookie.split(";");
        let cookieObj = {};

        // 遍历所有Cookie，存入对象中
        for (let cookie of cookies) {
            let cookieName = cookie.split("=")[0];

            cookieObj[cookieName] = cookie.split("=")[1];
        }

        // 返回user对应的cookie的值
        return cookieObj[name];
    }
}

/**
 * 其他工具类
 * */
class Utils {
    /**
     * 将对象转化成json字符串
     *
     * @param obj 要转化的对象
     * @return {string} 转化成的json字符串
     * */
    toUrlFormat(obj) {
        let objJson = "";

        for (let key in obj) {
            objJson += key + "=" + obj[key] + "&";
        }

        objJson = objJson.substr(0, objJson.length - 1);

        return objJson;
    }

    toMd5(src) {

    }
}
