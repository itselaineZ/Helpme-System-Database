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
          {{ userdata.username }}
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
          <li>
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
      <!-- End Navbar -->
      <div class="content">
        <div class="col-md-12">
          <div class="card card-user">
            <div class="card-header">
              <h5 class="card-title">Detailes</h5>
              <p class="category">View Task's Details Here!</p>
            </div>
            <div class="card-body">
              <form>
                <div class="row">
                  <div class="col-md-6 pr-1">
                    <div class="form-group">
                      <label>Publisher (disabled)</label>
                      <input type="text" disabled="" class="form-control" v-model="taskitem.userdata.username">
                    </div>
                  </div>
                  <div class="col-md-6 px-1">
                    <div class="form-group">
                      <label>Publisher Addr (disabled)</label>
                      <input type="text" disabled="" class="form-control" v-model="taskitem.userdata.schdis">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <label>Task Title (disabled)</label>
                      <input type="text" disabled="" class="form-control" v-model="taskitem.taskdata.title"
                             placeholder="Outline of the task">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <label>Description (disabled)</label>
                      <textarea disabled="" class="form-control textarea" v-model="taskitem.taskdata.description"
                                placeholder="Detailed information about task">
                      </textarea>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="update ml-auto mr-auto">
                    <button type="submit" class="btn btn-primary btn-round" @click="cancel"
                            v-if="taskitem.userdata.id===userdata.id">
                      Cancel
                    </button>
                    <button type="submit" class="btn btn-primary btn-round" @click="receive"
                            v-else>
                      Receive
                    </button>
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
import {formatDate} from "@/plugins/Utils";

export default {
  name: "TaskDetailView.vue",
  data() {
    return {
      taskitem: {
        userdata: {
          username: "",
          schdis: ""
        },
        taskdata: {
          id: 0,
          title: "",
          description: ""
        }
      },
      userdata: {
        id: 0
      }
    }
  },
  created() {
    this.taskid = this.$route.query.id
    const userdata = JSON.parse(sessionStorage.getItem("userdata"))
    this.userdata = userdata
    const _this = this
    this.$axios.get('http://localhost:8181/task/itemById', {params: {taskid: _this.taskid}})
        .then(function (resp) {
          _this.taskitem = resp.data
        })
  },
  methods: {
    receive() {
      let taskdata = this.taskitem.taskdata
      taskdata.receiverid = this.userdata.id
      this.$axios.post('http://localhost:8181/task/receive', taskdata)

      let d = new Date()
      let notification = {
        receiverid: this.userdata.id,
        taskid: this.taskitem.taskdata.id,
        title: "[NEW RECEIVE] <" + this.taskitem.taskdata.title + "> has been received!",
        content: "Your Task ID is " + this.taskitem.taskdata.id + "\n[CONTENT]\n"
            + this.taskitem.taskdata.description + "\n[STATUS]\n" + "received",
        time: formatDate(d.getTime())
      }
      console.log(notification)
      this.$axios.post('http://localhost:8181/notification/save', notification)

      this.$router.push({
        path: '/tasklist',
        query: {
          keywords: this.input,
          type: this.type,
          date: new Date().getTime()
        }
      })
    },
    cancel() {
      const _this = this
      this.$axios.get('http://localhost:8181/task/deleteById',
          {params: {taskid: _this.taskitem.taskdata.id}})

      let d = new Date()
      let notification = {
        receiverid: this.userdata.id,
        taskid: this.taskitem.taskdata.id,
        title: "[CANCELED] <" + this.taskitem.taskdata.title + "> has been canceled!",
        content: "Your Task ID is " + this.taskitem.taskdata.id + "\n[CONTENT]\n"
            + this.taskitem.taskdata.description + "\n[STATUS]\n" + "canceled",
        time: formatDate(d.getTime())
      }
      this.$axios.post('http://localhost:8181/notification/save', notification)

      this.$router.push({
        path: '/tasklist',
        query: {
          keywords: this.input,
          type: this.type,
          date: new Date().getTime()
        }
      })
    }
  }
}
</script>

<style scoped>

</style>