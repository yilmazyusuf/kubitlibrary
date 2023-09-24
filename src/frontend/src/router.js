import { createWebHistory, createRouter } from "vue-router";
import KubitHome from "@/views/KubitHome.vue";
import BookCreate from "@/views/Books/BookCreate.vue";
import BookEdit from "@/views/Books/BookEdit.vue";
import BookList from "@/views/Books/BookList.vue";

const routes = [
  {
    path: "/",
    name: "KubitHome",
    component: KubitHome,
  },
  {
    path: "/books/add",
    name: "BookCreate",
    component: BookCreate,
  },
    {
      path: "/books",
      name: "Booklist",
      component: BookList,
    },
   {
      path: "/books/edit/:id",
      name: "BookEdit",
      component: BookEdit,
    },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;