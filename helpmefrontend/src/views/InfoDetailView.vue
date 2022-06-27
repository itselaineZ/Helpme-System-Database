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
              <h5 class="card-title">Notification Info</h5>
              <p class="category">View Notification's Info Here!</p>
            </div>
            <div class="card-body">
              <form>
                <div class="row">
                  <div class="col-md-12 pr-1">
                    <div class="form-group">
                      <label>Title</label>
                      <input type="text" disabled="" class="form-control" v-model="notification.title">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <label>Time</label>
                      <input type="text" disabled="" class="form-control" v-model="notification.time"
                             placeholder="Outline of the task">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <label>Information Detail</label>
                      <textarea disabled="" class="form-control textarea" v-model="notification.content"
                                placeholder="Detailed information about task" style="height: 300px">
                      </textarea>
                    </div>
                  </div>
                </div>
                <router-link :to="{path:'/tasklist/taskdetail', query: {id:notification.taskid}}">
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">
                        Task Detail
                      </button>
                    </div>
                  </div>
                </router-link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "InfoDetailView.vue",
  data() {
    return {
      notification: this.notification
    }
  },
  created() {
    const userdata = JSON.parse(sessionStorage.getItem("userdata"))
    this.userdata = userdata
    const _this = this
    this.$axios.get('http://localhost:8181/notification/findById',
        {params: {id: _this.$route.query.id}}).then(function (resp) {
      _this.notification = resp.data
    })
  }
}
</script>

<style scoped>

</style>