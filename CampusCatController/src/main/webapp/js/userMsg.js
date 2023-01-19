const myAxios = axios.create(
    {
        baseURL: '/CampusCat'
    }
);
async function userMsg(title) {
    let u = (await myAxios.get("/users")).data;
    if (u.code === 20021) {
        let user = u.data;
        if (title !== "") {
            document.title = user.username + title;
        }
        document.getElementById("headText").innerText = "你好，" + user.username;
        if (user.admin) {
            document.getElementById('headText').innerText = document.getElementById('headText').innerText + '（管理员）';
        }
        return user;
    } else {
        alert("错误：" + u.msg + "\n错误代码：" + u.code);
        return {
            username: "visitor",
            admin: false
        };
    }

}