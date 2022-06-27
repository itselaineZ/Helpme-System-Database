export function formatDate(datetime) {
    let date = new Date(datetime)// 时间戳为10位需*1000，时间戳为13位的话不需乘1000
    let year = date.getFullYear()
    let month = ('0' + (date.getMonth() + 1)).slice(-2)
    let sdate = ('0' + date.getDate()).slice(-2)
    let hour = ('0' + date.getHours()).slice(-2)
    let minute = ('0' + date.getMinutes()).slice(-2)
    let second = ('0' + date.getSeconds()).slice(-2)
    // 拼接
    let result = year + '-' + month + '-' + sdate + ' ' + hour + ':' + minute + ':' + second
    // 返回
    return result
}