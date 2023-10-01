<template>
  <div class="main-content">
    <div class="breadcrumb">
      <h1>Books</h1>
    </div>
    <div class="separator-breadcrumb border-top"></div>

    <div class="row">
      <div class="col-md-12">
        <div class="card mb-5">
          <div class="card-body">
            <div class="responsive">
              <table class="table table-striped">
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
                        class="btn btn-success mr-1"
                        v-bind:href="'/books/edit/'+book.id"
                    ><i class="nav-icon i-Pen-2"></i
                    ></a>
                    <a
                        class="btn btn-danger"
                        v-bind:href="'/books/edit/'+book.id"
                    ><i class="nav-icon i-Close-Window"></i
                    ></a>
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
        })
        .catch(e => {
          console.log(e);
        });
  }
}
</script>
