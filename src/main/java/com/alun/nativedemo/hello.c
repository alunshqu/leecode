#include <jni.h>
#include <stdio.h>
#include "hello.h"
JNIEXPORT void JNICALL Java_com_alun_nativedemo_NativeDemo_sayHello(JNIEnv *, jobject) {
    printf("Hello Native \n");
    return;
}
