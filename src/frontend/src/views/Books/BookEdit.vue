<template>
  <div class="main-content">
    <div class="breadcrumb">
      <h1>Update Book</h1>
    </div>
    <div class="separator-breadcrumb border-top"></div>

    <div class="row">
      <div class="col-md-6">
        <div class="card mb-5">
          <div class="card-body">
            <form v-on:submit.prevent>
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
                  <button class="btn btn-primary" @click="updateBook">
                    Update Book
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
import router from "@/router";

export default {
  name: 'add-book',
  data() {
    return {
      book: {
        'id': null,
        'name': '',
        'description': ''
      }
    }
  },
  methods: {
    updateBook() {
      var data = {
        name: this.book.name,
        description: this.book.description
      };
      FormHelper.clearFormErrors();
      BookData.updateBook(this.book.id, data)
          .then(response => {
            if(response.data.status === true){
              if(response.data.redirect === true){
                router.push({ path: response.data.redirectUrl});
                setTimeout(function() {
                    FormHelper.toastSuccess('Book updated successfully');
                }, 1);


              }
            }
            console.log(response.data);
          })
          .catch(e => {
                if(e.response.status == 400){
                    FormHelper.showInputErrors(e.response.data);
                }
          });
    }

  },
  mounted() {
    BookData.getBook(this.$route.params.id)
        .then(response => {
          this.book = response.data
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
  }
}
</script>
