.class public Lcom/guaju/guajuandfix/MainActivity_CF;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "MainActivity"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public installpatch(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 29
    const/4 v1, 0x1

    :try_start_0
    sput-boolean v1, Lcom/guaju/guajuandfix/MyApplication;->isHasPatch:Z

    .line 30
    sget-object v1, Lcom/guaju/guajuandfix/MyApplication;->andFixManager:Lcom/guaju/guajuandfix/AndFixManager;

    invoke-virtual {v1}, Lcom/guaju/guajuandfix/AndFixManager;->checkHasPatch()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 34
    :goto_0
    return-void

    .line 31
    :catch_0
    move-exception v0

    .line 32
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 16
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 17
    const v0, 0x7f09001b

    invoke-virtual {p0, v0}, Lcom/guaju/guajuandfix/MainActivity_CF;->setContentView(I)V

    .line 18
    return-void
.end method

.method public print(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .annotation runtime Lcom/alipay/euler/andfix/annotation/MethodReplace;
        clazz = "com.guaju.guajuandfix.MainActivity"
        method = "print"
    .end annotation

    .prologue
    .line 21
    const-string v0, "MainActivity"

    const-string v1, "nobug\u4e86"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 22
    const-string v0, "\u6ca1\u6709bug\u4e86"

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 25
    return-void
.end method
