# Git学习

## 1.常用的Linux命令

```
1) cd: 改变目录
2) cd ..: 回退到上一个目录 
3) pwd: 显示当前所在目录路径
4) ls(ll): 列出当前目录的所有文件ll更为详细
5) touch: 新建一个文件 比如：touch index.js 就会在当前目录创建index.js文件
6) rm: 删除一个文件,rm index.js 就会把index.js删除
7) mkdir: 新建一个文件夹
8) rm -r: 删除一个文件夹
9) mv: 移动文件, mv index.html src (index.html是要移动的文件，src是目标文件夹)
10) reset: 重新初始化终端/清屏
11) clear: 清屏
12) history: 查看历史命令
13) help: 帮助
14) exit: 退出
15) #: 表示注释

```

```
git config -l: 查看所有配置
git config --system --list: 查看系统配置
git config --global --list: 查看用户配置
```

git配置文件在git安装目录下的etc文件夹下的gitconfig文件内

> 初次使用git需配置用户信息

git的用户配置文件在C:/用户/用户名/.gitconfig 文件内

````shell
git config --global user.name "username" #名称
git config --global user.email "xxx@xx.com" #邮箱
````



## 2.Git基本理论（核心）

>工作区域

Git本地有三个工作区域：工作目录（Working Directory），暂存区（Stage/Index），资源库（Repository或者Git Repository）。如果再加上远程的Git仓库（Remote Directory）就可以分为四个工作区域。文件正在这四个区域之间转换关系如下：

![image-20200807125234930](Untitled.assets/image-20200807125234930.png)

> Git工作流程

1.在工作目录中添加，修改文件； 

2.将需要进行版本管理的文件放入暂存区域； `git add .`

3.将暂存区文件提交到仓库  `git commit`

4.从仓库提交到远端仓库 `git push`



## 3.具体步骤

#### 1.本地仓库搭建

创建本地仓库的方法有两种：一种是创建全新的仓库，一种是克隆远程仓库

1.创建全新的仓库,需要用Git管理的项目的根目录执行，执行后可以看到项目目录多了个.git目录

```shell
# 在当前目录新建一个Git代码仓库
$ Git init
```

2.克隆远程目录，从远程服务器上的仓库备份下来

```shell
git clone [url] https://gitee.com/kuangstudy/openclass.git
```



#### 2.文件的四种状态

> 文件的四种状态

版本控制就是对文件的版本控制，要对文件进行修改、提交等操作，首先要知道文件当前在什么状态，不然可能会提交了现在还不想提交的文件，或者要提交的文件没提交上。

- Untracked: 未跟踪, 此文件在文件夹中, 但并没有加入到git库, 不参与版本控制. 通过git add 状态变为Staged.
- Unmodify: 文件已经入库, 未修改, 即版本库中的文件快照内容与文件夹中完全一致. 这种类型的文件有两种去处, 如果它被修改, 而变为Modified. 如果使用git rm移出版本库, 则成为Untracked文件
- Modified: 文件已修改, 仅仅是修改, 并没有进行其他的操作. 这个文件也有两个去处, 通过git add可进入暂存staged状态, 使用git checkout 则丢弃修改过, 返回到unmodify状态, 这个git checkout即从库中取出文件, 覆盖当前修改 !
- Staged: 暂存状态. 执行git commit则将修改同步到库中, 这时库中的文件和本地文件又变为一致, 文件为Unmodify状态. 执行git reset HEAD filename取消暂存, 文件状态为Modified

>查看文件状态

上面说文件有4种状态，通过如下命令可以查看到文件的状态：

```shell
# 查看指定文件状态
git status [filename]

# 查看所有文件状态
git status

# git add .       添加所有文件到暂存区
# git commit -m   提交暂存区的中的内容到本地仓库   -m 提交信息
```



## 3.忽略文件

>忽略文件

有些时候我们不想把某些文件纳入版本控制中，比如数据库文件，临时文件，设计文件等

在主目录下建立".gitignore"文件，此文件有如下规则：

1. 忽略文件中的空行或以井号（#）开始的行将会被忽略。

2. 可以使用Linux通配符。例如：星号（*）代表任意多个字符，问号（？）代表一个字符，方括号（[abc]）代表可选字符范围，大括号（{string1,string2,...}）代表可选的字符串等。

3. 如果名称的最前面有一个感叹号（!），表示例外规则，将不被忽略。

4. 如果名称的最前面是一个路径分隔符（/），表示要忽略的文件在此目录下，而子目录中的文件不忽略。

5. 如果名称的最后面是一个路径分隔符（/），表示要忽略的是此目录下该名称的子目录，而非文件（默认文件或目录都忽略）。

   

```shell
#为注释
*.txt        #忽略所有 .txt结尾的文件,这样的话上传就不会被选中！
!lib.txt     #但lib.txt除外
/temp        #仅忽略项目根目录下的TODO文件,不包括其它目录temp
build/       #忽略build/目录下的所有文件
doc/*.txt    #会忽略 doc/notes.txt 但不包括 doc/server/arch.txt
```



## 4.使用码云,github

#### 1.设置本机绑定SSH公钥

1.设置本机绑定SSH公钥，实现免密码登录

```shell
# 进入 C:\Users\Administrator\.ssh 目录
# 生成公钥
ssh-keygen -t rsa
```

2.将公钥信息public key 添加到码云账户中即可！

![image-20200807183712132](git学习.assets/image-20200807183712132.png)

4、使用码云创建一个自己的仓库！

![image-20200807183749259](git学习.assets/image-20200807183749259.png)

## 5.Git分支

分支在GIT中相对较难，分支就是科幻电影里面的平行宇宙，如果两个平行宇宙互不干扰，那对现在的你也没啥影响。不过，在某个时间点，两个平行宇宙合并了，我们就需要处理一些问题

![image-20200807200818653](git学习.assets/image-20200807200818653.png)

git分支中常用指令：

```shell
# 列出所有本地分支
git branch

# 列出所有远程分支
git branch -r

# 新建一个分支，但依然停留在当前分支
git branch [branch-name]

# 新建一个分支，并切换到该分支
git checkout -b [branch]

# 合并指定分支到当前分支
$ git merge [branch]

# 删除分支
$ git branch -d [branch-name]

# 删除远程分支
$ git push origin --delete [branch-name]
$ git branch -dr [remote/branch]
```

多个分支并行，代码就会不冲突，也就是多版本



## 6.回滚造成数据丢失

```
可以通过reflog来进行恢复，前提是丢失的分支或commit信息没有被git gc清除

一般情况下，gc对那些无用的object会保留很长时间后才清除的

可以使用git reflog show或git log -g命令来看到所有的操作日志

恢复的过程很简单：

通过git log -g命令来找到需要恢复的信息对应的commitid，可以通过提交的时间和日期来辨别,找到执行reset --hard之前的那个commit对应的commitid
```



## 7.一个项目push到多个仓库

#### 方法一：

使用 `git remote add`命令

- 1.1# 如下命令查看远程仓库的情况，可以看到只有一个叫 origin的远程仓库。

```
git remote
```



```undefined
origin
git remote -v
```



```cpp
origin  http://zhangxiaoning@47.93.247.175:10101/r/wdy_android.git (fetch)
origin  http://zhangxiaoning@47.93.247.175:10101/r/wdy_android.git (push)
```

- 1.2# 使用如下命令再添加一个远程仓库（这里以码云为例）

```
git remote add oschina https://gitee.com/qqjd/wdy_android.git
```

- 1.3# 再次查看远程仓库的情况，可以看到已经有两个远程仓库了。然后再使用相应的命令 push 到对应的仓库就行了。这种方法的缺点是每次要 push 两次。

```
git remote
```



```undefined
origin
oschina
git remote -v
```



```cpp
origin  http://zhangxiaoning@47.93.247.175:10101/r/wdy_android.git (fetch)
origin  http://zhangxiaoning@47.93.247.175:10101/r/wdy_android.git (push)
oschina https://gitee.com/qqjd/wdy_android.git (fetch)
oschina https://gitee.com/qqjd/wdy_android.git (push)
```



#### 方法二：

使用 git remote set-url 命令
 2.1# 删除方法一的 oschina 远程仓库。

git remote rm oschina
 2.2# 使用如下命令添加远程仓库。

git remote set-url --add github https://git.oschina.net/zxbetter/test.git
 2.3# 查看远程仓库情况。可以看到 github 远程仓库有两个 push 地址。这种方法的好处是每次只需要 push 一次就行了。

git remote -v
 github  https://github.com/zxbetter/test.git (fetch)
 github  https://github.com/zxbetter/test.git (push)
 github  https://git.oschina.net/zxbetter/test.git (push)



#### 方法三：

修改配置文件
 打开 .git/config 找到 [remote "github"]，添加对应的 url 即可，效果如下。这种方法其实和方法二是一样的。

[remote "github"]
 url = https://github.com/zxbetter/test.git
 fetch = +refs/heads/*:refs/remotes/github/*
 url = https://git.oschina.net/zxbetter/test.git
 关于 git pull
 方法二和三在 push 的时候比较方便。但是在 pull 的时候只能从方法三中的第一个 url 地址拉取代码。而方法一则不存在这种问题（可能要解决冲突）。
 所以，如果只进行 push 操作，推荐方法二和三，如果也要进行 pull 操作，推荐方法一。

http://www.voidcn.com/article/p-cuamptba-bny.html



## Git常用命令

#### 仓库

```shell
# 在当前目录新建一个Git代码库
$ git init

# 新建一个目录，将其初始化为Git代码库
$ git init [project-name]

# 下载一个项目和它的整个代码历史
$ git clone [url]
```



#### 配置 

```shell
# 显示当前的Git配置
$ git config --list

# 编辑Git配置文件
$ git config -e [--global]

# 设置提交代码时的用户信息
$ git config [--global] user.name "[name]"
$ git config [--global] user.email "[email address]"
```



#### 增加删除文件

```shell
# 添加指定文件到暂存区
$ git add [file1] [file2] ...

# 添加指定目录到暂存区，包括子目录
$ git add [dir]

# 添加当前目录的所有文件到暂存区
$ git add .

# 添加每个变化前，都会要求确认
# 对于同一个文件的多处变化，可以实现分次提交
$ git add -p

# 删除工作区文件，并且将这次删除放入暂存区
$ git rm [file1] [file2] ...

# 停止追踪指定文件，但该文件会保留在工作区
$ git rm --cached [file]

# 改名文件，并且将这个改名放入暂存区
$ git mv [file-original] [file-renamed]
```



#### 代码提交

```shell
# 提交暂存区到仓库区
$ git commit -m [message]

# 提交暂存区的指定文件到仓库区
$ git commit [file1] [file2] ... -m [message]

# 提交工作区自上次commit之后的变化，直接到仓库区
$ git commit -a

# 提交时显示所有diff信息
$ git commit -v

# 使用一次新的commit，替代上一次提交
# 如果代码没有任何新变化，则用来改写上一次commit的提交信息
$ git commit --amend -m [message]

# 重做上一次commit，并包括指定文件的新变化
$ git commit --amend [file1] [file2] ...
```



#### 分支

```shell
# 列出所有本地分支
$ git branch

# 列出所有远程分支
$ git branch -r

# 列出所有本地分支和远程分支
$ git branch -a

# 新建一个分支，但依然停留在当前分支
$ git branch [branch-name]

# 新建一个分支，并切换到该分支
$ git checkout -b [branch]

# 新建一个分支，指向指定commit
$ git branch [branch] [commit]

# 新建一个分支，与指定的远程分支建立追踪关系
$ git branch --track [branch] [remote-branch]

# 切换到指定分支，并更新工作区
$ git checkout [branch-name]

# 切换到上一个分支
$ git checkout -

# 建立追踪关系，在现有分支与指定的远程分支之间
$ git branch --set-upstream [branch] [remote-branch]

# 合并指定分支到当前分支
$ git merge [branch]

# 选择一个commit，合并进当前分支
$ git cherry-pick [commit]

# 删除分支
$ git branch -d [branch-name]

# 删除远程分支
$ git push origin --delete [branch-name]
$ git branch -dr [remote/branch]
```



#### 标签

```shell
# 列出所有tag
$ git tag

# 新建一个tag在当前commit
$ git tag [tag]

# 新建一个tag在指定commit
$ git tag [tag] [commit]

# 删除本地tag
$ git tag -d [tag]

# 删除远程tag
$ git push origin :refs/tags/[tagName]

# 查看tag信息
$ git show [tag]

# 提交指定tag
$ git push [remote] [tag]

# 提交所有tag
$ git push [remote] --tags

# 新建一个分支，指向某个tag
$ git checkout -b [branch] [tag]
```



#### 查看信息

```shell
# 显示有变更的文件
$ git status

# 显示当前分支的版本历史
$ git log

# 显示commit历史，以及每次commit发生变更的文件
$ git log --stat

# 搜索提交历史，根据关键词
$ git log -S [keyword]

# 显示某个commit之后的所有变动，每个commit占据一行
$ git log [tag] HEAD --pretty=format:%s

# 显示某个commit之后的所有变动，其"提交说明"必须符合搜索条件
$ git log [tag] HEAD --grep feature

# 显示某个文件的版本历史，包括文件改名
$ git log --follow [file]
$ git whatchanged [file]

# 显示指定文件相关的每一次diff
$ git log -p [file]

# 显示过去5次提交
$ git log -5 --pretty --oneline

# 显示所有提交过的用户，按提交次数排序
$ git shortlog -sn

# 显示指定文件是什么人在什么时间修改过
$ git blame [file]

# 显示暂存区和工作区的差异
$ git diff

# 显示暂存区和上一个commit的差异
$ git diff --cached [file]

# 显示工作区与当前分支最新commit之间的差异
$ git diff HEAD

# 显示两次提交之间的差异
$ git diff [first-branch]...[second-branch]

# 显示今天你写了多少行代码
$ git diff --shortstat "@{0 day ago}"

# 显示某次提交的元数据和内容变化
$ git show [commit]

# 显示某次提交发生变化的文件
$ git show --name-only [commit]

# 显示某次提交时，某个文件的内容
$ git show [commit]:[filename]

# 显示当前分支的最近几次提交
$ git reflog
```



#### 远程同步

```shell
# 下载远程仓库的所有变动
$ git fetch [remote]

# 显示所有远程仓库
$ git remote -v

# 显示某个远程仓库的信息
$ git remote show [remote]

# 增加一个新的远程仓库，并命名
$ git remote add [shortname] [url]

# 取回远程仓库的变化，并与本地分支合并
$ git pull [remote] [branch]

# 上传本地指定分支到远程仓库
$ git push [remote] [branch]

# 强行推送当前分支到远程仓库，即使有冲突
$ git push [remote] --force

# 推送所有分支到远程仓库
$ git push [remote] --all
```



#### 撤销

```shell
# 恢复暂存区的指定文件到工作区
$ git checkout [file]

# 恢复某个commit的指定文件到暂存区和工作区
$ git checkout [commit] [file]

# 恢复暂存区的所有文件到工作区
$ git checkout .

# 重置暂存区的指定文件，与上一次commit保持一致，但工作区不变
$ git reset [file]

# 重置暂存区与工作区，与上一次commit保持一致
$ git reset --hard

# 重置当前分支的指针为指定commit，同时重置暂存区，但工作区不变
$ git reset [commit]

# 重置当前分支的HEAD为指定commit，同时重置暂存区和工作区，与指定commit一致
$ git reset --hard [commit]

# 重置当前HEAD为指定commit，但保持暂存区和工作区不变
$ git reset --keep [commit]

# 新建一个commit，用来撤销指定commit
# 后者的所有变化都将被前者抵消，并且应用到当前分支
$ git revert [commit]

暂时将未提交的变化移除，稍后再移入
$ git stash
$ git stash pop
```



#### 其他

```shell
# 生成一个可供发布的压缩包
$ git archive
```



## Git教学



[码云](https://gitee.com/all-about-git)

[狂神说](https://www.bilibili.com/video/BV1FE411P7B3)



>代码参考：狂神说JAVA

[码云](https://gitee.com/all-about-git)

[狂神说](https://www.bilibili.com/video/BV1FE411P7B3)