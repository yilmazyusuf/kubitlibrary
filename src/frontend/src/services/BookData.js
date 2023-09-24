import http from "../http";
class BookData {
    create(data) {
        return http.post("/books", data);
      }
    getAll() {
        return http.get("/books");
    }
    getBook(id) {
        return http.get("/books/edit/"+id);
    }
     updateBook(id, data) {
        return http.put("/books/edit/"+id, data);
      }
}
export default new BookData();