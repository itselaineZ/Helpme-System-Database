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
          {{userdata.username}}
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
            <a href="./map.vue">
              <i class="nc-icon nc-pin-3"></i>
              <p>Maps</p>
            </a>
          </li>
          <li>
            <router-link to="/notification">
              <i class="nc-icon nc-bell-55"></i>
              <p>Notifications</p>
            </router-link>
          </li>
          <li>
            <router-link to="/userprofile">
              <i class="nc-icon nc-single-02"></i>
              <p>User Profile</p>
            </router-link>
          </li>
          <li>
            <router-link to="/tasklist">
              <i class="nc-icon nc-tile-56"></i>
              <p>Task List</p>
            </router-link>
          </li>
          <li class="active ">
            <router-link to="/publish">
              <i class="nc-icon nc-caps-small"></i>
              <p>Publish</p>
            </router-link>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
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
            <a class="navbar-brand" href="javascript:;">Task List</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
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
                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
      <!-- End Navbar -->
      <div class="content">
        <div class="col-md-12">
          <div class="card card-user">
            <div class="card-header">
              <h5 class="card-title">Publish a Task</h5>
              <p class="category">publish a task here!</p>
            </div>
            <div class="card-body">
              <form @submit.prevent="publish">
                <div class="row">
                  <div class="col-md-4 pr-1">
                    <div class="form-group">
                      <label>Publisher (disabled)</label>
                      <input type="text" disabled="" class="form-control" v-model="userdata.username">
                    </div>
                  </div>
                  <div class="col-md-4 px-1">
                    <div class="form-group">
                      <label>Publisher STUID (disabled)</label>
                      <input type="text" disabled="" class="form-control" v-model="userdata.stuid">
                    </div>
                  </div>
                  <div class="col-md-4 pl-1">
                    <div class="form-group">
                      <label>Phone Number (disabled)</label>
                      <input type="text" disabled="" class="form-control" v-model="userdata.telenumber">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <label>Task Title</label>
                      <input type="text" class="form-control" v-model="taskdata.title"
                             placeholder="Outline of the task">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <label>Description</label>
                      <textarea class="form-control textarea" v-model="taskdata.description"
                                placeholder="Detailed information about your task">
                      </textarea>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="update ml-auto mr-auto">
                    <button type="submit" class="btn btn-primary btn-round">Publish</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {formatDate} from '../plugins/Utils'
export default {
  name: "PublishView.vue",
  data(){
    return {
      userdata: this.userdata,
      taskdata:{
        publisherid: 0,
        reeiverid: 0,
        title: "",
        description: "",
        status: ""
      }
    }
  },
  created(){
    const userdata = JSON.parse(sessionStorage.getItem("userdata"))
    this.userdata = userdata
  },
  methods:{
    publish(){
      this.taskdata.publisherid = this.userdata.id
      this.taskdata.status = "sending to backend"
      const _this = this
      this.$axios.post('http://localhost:8181/task/save', this.taskdata).then(function (resp){
        _this.taskid = resp.data
        if (resp.data !== -1) {
          let d = new Date()
          let notification={
            receiverid: _this.userdata.id,
            taskid: _this.taskid,
            title: "[NEW PUBLISH] <"+_this.taskdata.title+"> has been published!",
            content: "Your Task ID is "+_this.taskid+"\n[CONTENT]\n"+_this.taskdata.description
                +"\n[STATUS]\n"+"waiting for receiving",
            time: formatDate(d.getTime())
          }
          _this.$axios.post('http://localhost:8181/notification/save', notification)
          _this.userdata.publishing = _this.userdata.publishing+1
          _this.$axios.post('http://localhost:8181/user/updateUserTaskInfo', _this.userdata)
          alert('发布成功！')
          _this.$router.push('/publish')
        }else{
          alert('发布失败！')
        }
      })
    }
  }
}
</script>

<style scoped>

</style>