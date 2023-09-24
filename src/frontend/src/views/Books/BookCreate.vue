<template>
  <div class="main-content">
    <div class="breadcrumb">
      <h1>Create New Book</h1>
    </div>
    <div class="separator-breadcrumb border-top"></div>

    <div class="row">
      <div class="col-md-6">
        <div class="card mb-5">
          <div class="card-body">
            <form v-on:submit.prevent>
              <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="name">Name</label>
                <div class="col-sm-10">
                  <input
                      class="form-control"
                      id="name"
                      type="text"
                      name="name"
                      v-model="book.name"
                      placeholder="Name"
                  />
                </div>
              </div>

              <div class="form-group row">
                <label class="col-sm-2 col-form-label"></label>
                <div class="col-sm-10">
                  <button class="btn btn-primary" @click="saveBook">
                    Add New Book
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- end of main-content -->
  </div>
</template>

<script>
import BookData from "../../services/BookData";
import router from '../../router'

export default {
  name: 'add-book',
  data() {
    return {
      book: {name: ""}
    }
  },
  methods: {
    saveBook() {
      let data = {
        name: this.book.name
      };
      BookData.create(data)
          .then(response => {
            if(response.data.status === true){
              if(response.data.redirect === true){
                router.push({ path: response.data.redirectUrl })
              }
            }
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }
  }
}
</script>
