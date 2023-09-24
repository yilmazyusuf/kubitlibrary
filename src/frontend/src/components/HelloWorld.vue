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
                                    <div class="col-md-6">

                                        <div class="card mb-5">
                                            <div class="card-body">
                                                <form>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 col-form-label" for="inputEmail3">Email</label>
                                                        <div class="col-sm-10">
                                                            <input class="form-control" id="inputEmail3" type="email" placeholder="Email">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 col-form-label" for="inputPassword3">Password</label>
                                                        <div class="col-sm-10">
                                                            <input class="form-control" id="inputPassword3" type="password" placeholder="Password">
                                                        </div>
                                                    </div>
                                                    <fieldset class="form-group">
                                                        <div class="row">
                                                            <div class="col-form-label col-sm-2 pt-0">Radios</div>
                                                            <div class="col-sm-10">
                                                                <div class="form-check">
                                                                    <input class="form-check-input" id="gridRadios1" type="radio" name="gridRadios" value="option1" checked="checked">
                                                                    <label class="form-check-label ml-3" for="gridRadios1">
                                                                        First radio

                                                                    </label>
                                                                </div>
                                                                <div class="form-check">
                                                                    <input class="form-check-input" id="gridRadios2" type="radio" name="gridRadios" value="option2">
                                                                    <label class="form-check-label ml-3" for="gridRadios2">
                                                                        Second radio

                                                                    </label>
                                                                </div>
                                                                <div class="form-check disabled">
                                                                    <input class="form-check-input" id="gridRadios3" type="radio" name="gridRadios" value="option3" disabled="disabled">
                                                                    <label class="form-check-label ml-3" for="gridRadios3">
                                                                        Third disabled radio

                                                                    </label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </fieldset>
                                                    <div class="form-group row">
                                                        <div class="col-sm-2">Checkbox</div>
                                                        <div class="col-sm-10">
                                                            <div class="form-check">
                                                                <input class="form-check-input" id="gridCheck1" type="checkbox">
                                                                <label class="form-check-label ml-3" for="gridCheck1">
                                                                    Example checkbox

                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-sm-10">
                                                            <button class="btn btn-primary" type="submit">Sign in</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                <div class="row">
                <div class="col-md-12">
                <h1>{{ msg }}</h1>
                </div>

                </div>
                <!-- end of main-content -->
            </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    fetch("/api/hello")
      .then((response) => response.text())
      .then((data) => {
          this.msg = data;
      });
  }
}
</script>