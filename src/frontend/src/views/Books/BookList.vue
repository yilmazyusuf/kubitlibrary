<style>
.btn-block + .btn-block{
    margin-top:0px;
}
</style>
<template>
  <div class="main-content">
    <div class="breadcrumb">
      <h1>Books</h1>
    </div>
    <div class="separator-breadcrumb border-top"></div>

<div class="row">

                            <div class="col-md-3" v-for="book in books" v-bind:key="book.id">
                                <div class="card mb-4 o-hidden">
                                <img class="card-img-top" v-bind:src="'/images/books/'+book.media" alt="" style="height:20rem">
                                    <div class="card-body">
                                        <h5 class="card-title">{{ book.name }}</h5>

                                        <p class="card-text">{{ $filters.currencyUSD(book.description,'150','...') }}</p>
                                    </div>

                                    <div class="card-body" style="padding-top:0">
                                    <div class="btn-group btn-block" role="group" aria-label="Basic example">
                                        <a v-bind:href="'/books/edit/'+book.id" class="btn btn-outline-success btn-block" type="button"><i class="nav-icon i-Pen-2"></i> Edit</a>
                                        <a v-bind:href="'/books/edit/'+book.id" class="btn btn-outline-danger btn-block" type="button"><i class="nav-icon i-Close-Window"></i> Delete</a>
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
