import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue';
import UserView from '@/views/UserView.vue';
import LoginRegisterView from '@/views/LoginRegisterView.vue';
import UserprofileView from "@/views/UserprofileView";
import TaskView from "@/views/TaskView";
import PublishView from "@/views/PublishView";
import TaskDetailView from "@/views/TaskDetailView";
import NotificationView from "@/views/NotificationView";
import InfoDetailView from "@/views/InfoDetailView";

const routes = [
  {
    path: '/',
    name: 'begin',
    component: LoginRegisterView
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  {
    path: '/notification',
    name: 'notification',
    component: NotificationView
  },
  {
    path: '/notification/infodetail',
    name: 'infodetail',
    component: InfoDetailView
  },
  {
    path: '/userprofile',
    name: 'userprofile',
    component: UserprofileView
  },
  {
    path: '/tasklist',
    name: 'tasklist',
    component: TaskView
  },
  {
    path: '/tasklist/taskdetail',
    name: 'taskdetail',
    component: TaskDetailView
  },
  {
    path: '/publish',
    name: 'publish',
    component: PublishView
  },
  {
    path: '/users',
    name: 'users',
    component: UserView
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
