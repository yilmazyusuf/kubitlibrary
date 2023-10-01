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
            <form v-on:submit.prevent  novalidate>
              <div class="form-group row">
                <label class="col-sm-3 col-form-label" for="name">Name</label>
                <div class="col-sm-9">
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
                  <label class="col-sm-3 col-form-label" for="description">Description</label>
                  <div class="col-sm-9">
                    <textarea
                        class="form-control"
                        id="description"
                        name="description"
                        v-model="book.description"
                    />
                  </div>
                </div>

              <div class="form-group row">
                <label class="col-sm-3 col-form-label"></label>
                <div class="col-sm-9">
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
import FormHelper from "../../services/FormHelper";

import router from '../../router'

export default {
  name: 'add-book',
  data() {
    return {
      book: {
        name: "",
        description: "",
      }
    }
  },
  methods: {
    saveBook() {
      let data = {
        name: this.book.name,
        description: this.book.description,
      };

      FormHelper.clearFormErrors();
      BookData.create(data)
          .then(response => {
            if(response.data.status === true){
              if(response.data.redirect === true){
                    FormHelper.toastSuccess('Book created successfully');
                    setTimeout(function() {
                        router.push({ path: response.data.redirectUrl});
                    }, 3000);
              }
            }
          })
          .catch(e => {
                if(e.response.status == 400){
                   FormHelper.showInputErrors(e.response.data);
                }
          });

    }
  }
}
</script>
