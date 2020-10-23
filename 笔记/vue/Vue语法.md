## 双向绑定

`<span v-bind:title="message">鼠标悬停可查看</span>`

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
  </head>
  <body>
    <div id="app">
      {{message}}
      <br />
      <span v-bind:title="message">鼠标悬停可查看</span>
    </div>
  </body>

  <script
    type="text/javascript"
    src="https://lib.baomitu.com/vue/2.6.12/vue.common.dev.js"
  ></script>
  <script>
    var vm = new Vue({
      el: "#app",
      data: {
        message: "hello,vue",
      },
    });
  </script>
</html>
```



## v-if

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
  </head>
  <body>
    <div id="app">
      <h1 v-if="type==='A'">A</h1>
      <h1 v-else-if="type==='B'">B</h1>
      <h1 v-else>C</h1>
    </div>
  </body>

  <script
    type="text/javascript"
    src="https://lib.baomitu.com/vue/2.6.12/vue.common.dev.js"
  ></script>
  <script>
    var vm = new Vue({
      el: "#app",
      data: {
        type: "B",
      },
    });
  </script>
</html>
```



## v-for

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
  </head>
  <body>
    <div id="app">
      <li v-for="(item,index) in items">{{item.message}}---{{index}}</li>
    </div>
  </body>

  <script
    type="text/javascript"
    src="https://lib.baomitu.com/vue/2.6.12/vue.common.dev.js"
  ></script>
  <script>
    var vm = new Vue({
      el: "#app",
      data: {
        items: [{ message: "111" }, { message: "222" }],
      },
    });
  </script>
</html>
```



## function

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
  </head>
  <body>
    <div id="app">
      <button v-on:click="sayHi">click</button>
    </div>
  </body>

  <script
    type="text/javascript"
    src="https://lib.baomitu.com/vue/2.6.12/vue.common.dev.js"
  ></script>
  <script>
    var vm = new Vue({
      el: "#app",
      data: {
        message: "蔡嘉辰"
      },
      methods: {
        //方法必须定义在Vue的methods中,事件需监听
        sayHi: function(event){
          alert(this.message)
        }
      },
    });
  </script>
</html>
```



## 双向绑定

### 单选框

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
  </head>
  <body>
    <div id="app">
      <input type="radio" name="sex" value="男" v-model="message"> 男
      <input type="radio" name="sex" value="女" v-model="message" checked> 女

      <p> 选中了 : {{message}}</p>
    </div>
  </body>

  <script
    type="text/javascript"
    src="https://lib.baomitu.com/vue/2.6.12/vue.common.dev.js"
  ></script>
  <script>
    var vm = new Vue({
      el: "#app",
      data: {
        message: ""
      }
    });
  </script>
</html>
```

### 下拉框

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
  </head>
  <body>
    <div id="app">
      下拉框
      <select v-model="message">
        <option value="" disabled>请选择</option>
        <option>A</option>
        <option>B</option>
        <option>C</option>
      </select>
    </div>
  </body>

  <script
    type="text/javascript"
    src="https://lib.baomitu.com/vue/2.6.12/vue.common.dev.js"
  ></script>
  <script>
    var vm = new Vue({
      el: "#app",
      data: {
        message: ""
      }
    });
  </script>
</html>
```



## 组件

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
  </head>
  <body>
    <div id="app">
      <cjc v-for="item in items" v-bind:cai="item"></cjc>
    </div>
  </body>

  <script
    type="text/javascript"
    src="https://lib.baomitu.com/vue/2.6.12/vue.common.dev.js"
  ></script>
  <script>

    //定义一个vue组件component
    Vue.component("cjc",{
      props:['cai'],
      template: '<li>{{cai}}</li>'
    });

    var vm = new Vue({
      el: "#app",
      data: {
        items: ["java","linux","Android"]
      }
    });
  </script>
</html>
```



## axios

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <!-- 解决闪烁 -->
    <style>
      [v-clock]{
        display: none;
      }
    </style>

  </head>
  <body>
    <div id="vue">
      <div>{{info.name}}</div>
      <div>{{info.address.street}}</div>
      <a v-bind:href="info.url">点击</a>
    </div>
  </body>

  <script src="https://cdn.bootcdn.net/ajax/libs/vue/2.5.21/vue.min.js"></script>
  <script src="https://cdn.bootcdn.net/ajax/libs/axios/0.20.0/axios.min.js"></script>
  
  <script type="text/javascript">
    var vm = new Vue({
      el: "#vue",
      data() {
        return {
          info:{
            name: null,
            address: {
              street :null,
              city:null,
              country:null
            },
            url:null,
          }
        }
      },
      mounted() { //钩子函数
        axios.get('http://127.0.0.1:5500/data.json').then(response=>(this.info=response.data))
      },
    });
  </script>
</html>
```

