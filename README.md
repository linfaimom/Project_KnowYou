# Project_KnowYou
用于服务外包比赛。
# 2016.4.12
## 1.
解决了底部导航栏在不同设备的显示错位问题,把ImageView和TextView分别放入两个FrameLayout中,然后都在FrameLayout中设置居中显示,
这就保证了在不同尺寸的手机中都能达到预期的效果.
## 2.
google中查找到的答案,可以为FragmentTabHost中的标签页设置点击事件,如代码中的tabHost.getTabWidget().getChildAt(2).setOnClickListener(.....),
刚好解决了我想要让一个标签页看起来就像qq空间和微博"+"弹窗效果的问题.于是继续搜索,最终利用PopUpWindow实现类似效果.
# 2016.4.13
## 1.
在PopUpWindow中错用了方法setTouchInterceptor(),使得出现了按回退键时"+"不能变为"x".经摸索后,发现PopUpWindow有一个setOnDismissListener(....)
方法,即在PopUpWindow窗口消失时调用的方法,于是改用此方法,成功解决上述问题.
## 2.
更改了底部导航栏的标签信息,并新增了4个Fragment用于下次实现结合ViewPager的滑页功能.

