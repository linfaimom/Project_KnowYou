# Project_KnowYou
### 用于服务外包比赛。
# 2016.4.12
### 1.解决了底部导航栏在不同设备的显示错位问题,把ImageView和TextView分别放入两个FrameLayout中,然后都在FrameLayout设置中居中显示,这就保证了在不同尺寸的手机中都能达到预期的效果.
### 2.google中查找到的答案,可以为FragmentTabHost中的标签页设置点击事件,如代码中的tabHost.getTabWidget().getChildAt(2).setOnClickListener(.....),刚好解决了我想要让一个标签页看起来就像qq空间和微博"+"弹窗效果的问题.于是继续搜索,最终利用PopUpWindow实现类似效果.
# 2016.4.13
### 1.在PopUpWindow中错用了方法setTouchInterceptor(),使得出现了按回退键时"+"不能变为"x".经摸索后,发现PopUpWindow有一个setOnDismissListener(....)方法,即在PopUpWindow窗口消失时调用的方法,于是改用此方法,成功解决上述问题.
### 2.更改了底部导航栏的标签信息,并新增了4个Fragment用于下次实现结合ViewPager的滑页功能.
# 2016.4.14
### 使用了开源组件PagerSlidingTabStrip结合ViewPager实现了"附近"标签页中顶部导航栏加滑页的功能.
# 2016.4.15
### 今天满课加上一直输游戏,一点都没干,真是日了狗了.不过我申请了百度地图的API使用权,目前还在审核,到时可以加到"附近"这个Fragment中,实现定位功能.明天早上起来顺便把启动界面实现一下.
# 2016.4.16
### 实现了超级简陋的程序启动界面.
# 2016.4.17
### 1.在fragment"必吃美食"中加入了自定义的ListView.
### 2.晚上开会讨论后,更改了底部导航栏的命名,改天实现fragment"旅游"界面,打算同样采用PagerSlidingTabStrip结合ViewPager的方法实现.
# 2016.4.18
### 弃用了PagerSlidingTabStrip,改用开源组件FlycoTablayout中的SlidingTabLayout实现Discover中的顶部导航栏与滑动,实现了选中标签页时改变字体颜色,并将指示器的样式改变为了小三角形.
# 2016.4.23
### 我的天,这五天我在干啥,好像都没干什么事情...还是总结一下吧:
### 1.在"旅行中"加入了"推荐"和"驴友"这两个Fragment,使用开源组件FlycoTabLayout中的SlidingTabLayout结合ViewPager实现了顶部导航栏与滑动.
### 2.增添了一个搜索图标,点击跳转到"Search"Activity,里面有个并没什么卵用的搜索框,使用了AutoCompleteTextView,绑定了一些数据,在其中输入几个字会有下拉栏提示补全.还弄了个消息图标,不过还没给它绑定任何事件.
### 3.在"推荐"中加入了一个ViewPager,展示了四张风景图片.
### 4.将顶部底部导航栏的background都改成了白色,里面界面的background改成稍微有点灰色的颜色.
### 5.调整了PopUpWindow的显示高度,确保在不同的设备中有相同的显示效果.
# 2016.4.24
### 在suggest布局中加入了自定义的ScrollView控件,让视图可向下滑动,同时完美解决了与布局中嵌套的ViewPager控件的冲突问题.
