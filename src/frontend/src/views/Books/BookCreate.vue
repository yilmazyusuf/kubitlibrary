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
      <div class="col-md-3">
        <div class="card mb-5">
          <div class="card-body">
            <h6 class="card-title">Book Cover</h6>
            <!--https://github.com/saimow/vue-media-upload -->
            <Uploader
                server="/api/books/cover/upload"
                @change="changeMedia"

            />
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
import Uploader from 'vue-media-upload'
import router from '../../router'

export default {
  name: 'add-book',
  data() {
    return {
      book: {
        name: "",
        description: "",
      },
       media: []
    }
  },
  methods: {
    saveBook() {
      let data = {
        name: this.book.name,
        description: this.book.description,
        media: this.media.length > 0 ? this.media[0]['name']: null,
      };

      FormHelper.clearFormErrors();
      BookData.create(data)
          .then(response => {
            if(response.data.status === true){
              if(response.data.redirect === true){
                   router.push({ path: response.data.redirectUrl});
                    setTimeout(function() {
                         FormHelper.toastSuccess('Book created successfully');
                    }, 1);
              }
            }
          })
          .catch(e => {
                if(e.response.status == 400){
                   FormHelper.showInputErrors(e.response.data);
                }
          });

    },
    changeMedia(media){
      this.media = media;
    }
  },
  components: {
        Uploader
      },
}
</script>
