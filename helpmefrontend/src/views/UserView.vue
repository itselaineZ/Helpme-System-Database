<template>
  <div>
    <table style="align-content: center">
      <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>邮箱</td>
      </tr>
      <tr v-for="item in users">
        <td>{{item.username}}</td>
        <td>{{item.password}}</td>
        <td>{{item.email}}</td>
      </tr>
    </table>
    {{msg}}
  </div>
</template>

<script>
export default {
  name: "User.vue",
  data(){
    return{
      msg:'Hello Vue',
      users:[
        {
          id: 1,
          username: 'root',
          password: 'admin',
          email: '1952339@tongji.edu.cn'
        }
      ]
    }
  },
  created() {
    const _this = this
    this.$axios.get('http://localhost:8181/user/findAll').then(function (resp) {
      _this.users = resp.data
      console.log(resp.data)
    })
  }
}
</script>

<style scoped>

</style>