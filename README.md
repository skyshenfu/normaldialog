# 一个简易使用的仿ios的对话框

## 集成步骤

1. 添加jitpack仓库至项目根节点的build.gradle

   ``````groovy
   	allprojects {
   		repositories {
   			...
   			maven { url 'https://jitpack.io' }
   		}
   	}
   ``````

   ​

2.添加项目依赖至需要使用的子模块

```
dependencies {
	        compile 'com.github.skyshenfu:normaldialog:v0.2.0'
	}
```

## 具体使用

1. 双按钮dialog

```java
	new NormalDialogBuilder(MainActivity.this)
        .setTitleText("打工是不可能的")
        .setContentText("这辈子不可能打工")
        .setLeftText("确定呀")
        .setRightText("取消么")
        .setButtonRightTextColor(R.color.color_orange)
        .setButtonLeftTextColor(R.color.color_green)
        .setContentTextColor(R.color.color_red)
        .setTitleTextColor(R.color.color_blue)
        .setListener(new TwoButtonDialog.TwoClickListener() {
            @Override
            public void onLeftClick(View view) {
            }

            @Override
            public void onRightClick(View view) {

            }
        }).build().show();
```

2. 单按钮

```java
	new NormalDialogBuilder(MainActivity.this)
	    .setTitleText("打工是不可能的")
	    .setContentText("这辈子不可能打工")
	    .setLeftText("确定呀")
	    .setRightText("取消么")
	    .setButtonRightTextColor(R.color.color_orange)
	    .setButtonLeftTextColor(R.color.color_green)
	    .setContentTextColor(R.color.color_red)
	    .setTitleTextColor(R.color.color_blue)
	    .setListener(new TwoButtonDialog.TwoClickListener() {
	        @Override
	        public void onLeftClick(View view) {
	        }

	        @Override
	        public void onRightClick(View view) {

	        }
	    }).build().show();
```

3. 底部dialog

```java
	final String [] res1={"不知妻美刘强东","悔创阿里杰克马","北大还行撒贝宁","取消"};
	new BottomListDialog(MainActivity.this, res1, new ItemClickListener() {
	@Override
	public void clickItem(int position) {
		Toast.makeText(MainActivity.this, "here"+position, Toast.LENGTH_SHORT).show();
	}},false).show()
```

4. 单按钮,双按钮dialog动画效果(默认没有)

   ```java
   setAnimation(NormalDialogBuilder.TOPTOBOTTOM)//从上到下
   setAnimation(NormalDialogBuilder.LEFTTORIGHT)//从左到右
   ```

## 效果图

1.双按钮

![双按钮dialog](https://storage6.cuntuku.com/2017/12/29/KPVkr.png)

2.单按钮

![单按钮dialog](https://storage7.cuntuku.com/2017/12/29/KPZyJ.png)

3.底部dialog

![底部dialog](https://storage1.cuntuku.com/2017/12/29/KPzpE.png)

## 项目地址

[项目地址戳我](https://github.com/skyshenfu/normaldialog)

希望觉得有用的观众老爷给个star
