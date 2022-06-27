<template>
  <div class="wrapper ">
    <div class="sidebar" data-color="white" data-active-color="danger">
      <div class="logo">
        <a class="simple-text logo-mini">
          <div class="logo-image-small">
            <img src="../assets/img/logo-small.png">
          </div>
        </a>
        <a class="simple-text logo-normal">
          Login
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li>
            <router-link to="/home">
              <i class="nc-icon nc-bank"></i>
              <p>Home</p>
            </router-link>
          </li>
          <li>
            <router-link to="">
              <i class="nc-icon nc-pin-3"></i>
              <p>Maps</p>
            </router-link>
          </li>
          <li>
            <router-link to="">
              <i class="nc-icon nc-bell-55"></i>
              <p>Notifications</p>
            </router-link>
          </li>
          <li>
            <router-link to="">
              <i class="nc-icon nc-single-02"></i>
              <p>User Profile</p>
            </router-link>
          </li>
          <li>
            <router-link to="">
              <i class="nc-icon nc-tile-56"></i>
              <p>Task List</p>
            </router-link>
          </li>
          <li>
            <router-link to="">
              <i class="nc-icon nc-caps-small"></i>
              <p>Publish</p>
            </router-link>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="javascript:;">Login</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                  aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navigation">
            <form>
              <div class="input-group no-border">
                <input type="text" value="" class="form-control" placeholder="Search...">
                <div class="input-group-append">
                  <div class="input-group-text">
                    <i class="nc-icon nc-zoom-split"></i>
                  </div>
                </div>
              </div>
            </form>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link btn-magnify" href="javascript:;">
                  <i class="nc-icon nc-layout-11"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Stats</span>
                  </p>
                </a>
              </li>
              <li class="nav-item btn-rotate dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="nc-icon nc-bell-55"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Some Actions</span>
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#">Action</a>
                  <a class="dropdown-item" href="#">Another action</a>
                  <a class="dropdown-item" href="#">Something else here</a>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link btn-rotate" href="javascript:;">
                  <i class="nc-icon nc-settings-gear-65"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Account</span>
                  </p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="content">
        <div class="row">
          <div class="col-md-4">
            <div class="card card-user">
              <div class="card-header">
                <h5 class="card-title">Login Information</h5>
                <p class="category">Login here!</p>
              </div>
              <div style="width:33%; margin: 0 auto">
                <a class="simple-text logo-mini">
                  <div class="logo-image-small">
                    <img src="../assets/img/logo-small.png">
                  </div>
                </a>
              </div>
              <div class="card-body">
                <form @submit.prevent="login">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" placeholder="username" v-model="logindata.username">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" placeholder="password" v-model="logindata.password">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Login</button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-md-8">
            <div class="card card-user">
              <div class="card-header">
                <h5 class="card-title">User Information</h5>
                <p class="category">Register here!</p>
              </div>
              <div class="card-body">
                <form @submit.prevent="register">
                  <div class="row">
                    <div class="col-md-4 pr-1">
                      <div class="form-group">
                        <label>University</label>
                        <input type="text" class="form-control" placeholder="university Name"
                               v-model="registerdata.university">
                      </div>
                    </div>
                    <div class="col-md-4 px-1">
                      <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" placeholder="username" v-model="registerdata.username">
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label>Email address</label>
                        <input type="email" class="form-control" placeholder="email" v-model="registerdata.email">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-4 pr-1">
                      <div class="form-group">
                        <label>Telephone Number</label>
                        <input type="text" class="form-control" placeholder="telephone number"
                               v-model="registerdata.telenumber">
                      </div>
                    </div>
                    <div class="col-md-4 px-1">
                      <div class="form-group">
                        <label>Student ID</label>
                        <input type="text" class="form-control" placeholder="student id" v-model="registerdata.stuid">
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" placeholder="not less than 8 digits"
                               v-model="registerdata.password">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Department</label>
                        <input type="text" class="form-control" placeholder="department"
                               v-model="registerdata.department">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-4 pr-1">
                      <div class="form-group">
                        <label>City</label>
                        <input type="text" class="form-control" placeholder="city" v-model="registerdata.city">
                      </div>
                    </div>
                    <div class="col-md-4 px-1">
                      <div class="form-group">
                        <label>school districts</label>
                        <input type="text" class="form-control" placeholder="school districts"
                               v-model="registerdata.schdis">
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label>Dormitory</label>
                        <input type="text" class="form-control" placeholder="dormitory address"
                               v-model="registerdata.dorm">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Register</button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginRegisterView.vue",
  methods: {
    register() {
      const _this = this
      this.$axios.post('http://localhost:8181/user/save', this.registerdata).then(function (resp) {
        if (resp.data == 'success') {
          alert('注册成功！')
          _this.$router.push({
            path: '/',
            query: {
              keywords: this.input,
              type: this.type,
              date: new Date().getTime()
            }
          })
        }
      })
    },
    login() {
      //console.log(this.logindata)
      const _this = this
      this.$axios.post('http://localhost:8181/user/findByUsername', this.logindata).then(function (resp) {
        //console.log(resp.data)
        if (!resp.data) {
          alert('登陆失败！')
        } else {
          //this.showNotification('bottom','center',"Welcome")
          alert('登陆成功！')
          sessionStorage.setItem('userdata', JSON.stringify(resp.data))
          _this.$router.push('/home')
        }
      })
    }
  },
  data() {
    return {
      logindata: {
        username: "",
        password: ""
      },
      registerdata: {
        university: "",
        username: "",
        email: "",
        telenumber: "",
        stuid: "",
        password: "",
        department: "",
        city: "",
        schdis: "",
        dorm: "",
        publishing: 0,
        receiving: 0,
        published: 0,
        solved: 0
      }
    }
  }
}
</script>

<style scoped>

</style>