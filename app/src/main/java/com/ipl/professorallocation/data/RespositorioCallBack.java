package com.ipl.professorallocation.data;

public interface RespositorioCallBack<T> {
    void onResponse(T response);

    void onFailure(Throwable t);
}
