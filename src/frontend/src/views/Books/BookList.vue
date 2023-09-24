<template>
  <div class="main-content">
    <div class="breadcrumb">
      <h1>Blank</h1>
      <ul>
        <li><a href="">Pages</a></li>
        <li>Blank</li>
      </ul>
    </div>
    <div class="separator-breadcrumb border-top"></div>

    <div class="row">
      <div class="col-md-12">
        <div class="card mb-5">
          <div class="card-body">
            <div class="responsive">
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th style="width: 90%">Name</th>
                    <th>#</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="book in books" v-bind:key="book.id">
                    <td>{{ book.name }}</td>
                    <td>
                      <a
                        class="btn btn-success"
                        v-bind:href="'/books/edit/'+book.id"
                        ><i class="nav-icon i-Pen-2"></i
                      ></a>
                      <a
                        class="btn btn-danger"
                        v-bind:href="'/books/edit/'+book.id"
                        ><i class="nav-icon i-Close-Window"></i
                      ></a>
                       <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#exampleModalCenter">
                                                          Launch demo modal

                                                      </button>

                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- end of main-content -->
  </div>
              <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle-2" aria-hidden="true">
                      <div class="modal-dialog modal-dialog-centered" role="document">
                          <div class="modal-content">
                              <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalCenterTitle-2">Modal title</h5>
                                  <button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                              </div>
                              <div class="modal-body">
                                  ...

                              </div>
                              <div class="modal-footer">
                                  <button class="btn btn-secondary" type="button" data-dismiss="modal">Close</button>
                                  <button class="btn btn-primary ml-2" type="button">Save changes</button>
                              </div>
                          </div>
                      </div>
                  </div>
</template>

<script>
import BookData from "../../services/BookData";
export default {
  name: 'add-book',
  data() {
    return {
      books: null
    }
  },
  mounted() {
            BookData.getAll()
                    .then(response => {
                        this.books = response.data
                        console.log(response.data);
                    })
                    .catch(e => {
                      console.log(e);
                    });
  }
}
</script>
