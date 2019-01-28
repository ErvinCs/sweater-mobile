package com.example.csoka.lab_02_android.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.example.csoka.lab_02_android.model.Post;
import com.example.csoka.lab_02_android.repository.PostRepository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {
    private PostRepository mPostRepository;
    private LiveData<List<Post>> mAllPosts;

    public PostViewModel(Application application) {
        super(application);
        mPostRepository = new PostRepository(application);
        mAllPosts = mPostRepository.getAllPosts();
    }

    public LiveData<List<Post>> getAllPosts() {
        return mAllPosts;
    }

    public List<Post> getPostList() {
        return mAllPosts.getValue();
    }

    public boolean contains(Post post) {
        if(mAllPosts.getValue() != null)
            return mAllPosts.getValue().contains((post));
        else
            return false;
    }

    public void insert(Post post) {
        mPostRepository.insert(post);
    }

    public void deleteOne(Post post) {
        mPostRepository.deleteOne(post);
    }

    public void updateOne(Post newPost) {
        mPostRepository.updateOne(newPost);
    }
}
