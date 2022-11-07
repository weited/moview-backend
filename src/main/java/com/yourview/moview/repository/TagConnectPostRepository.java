package com.yourview.moview.repository;

import com.yourview.moview.entity.Post;
import com.yourview.moview.entity.Tag;
import com.yourview.moview.entity.TagConnectPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagConnectPostRepository extends JpaRepository<TagConnectPost, Long> {
    @Query(value = "SELECT tag_id, count(tag_id) as nums FROM moview.tag_connect_post\n" +
            "WHERE post_id in :postList\n" +
            "GROUP BY tag_id\n" +
            "ORDER BY nums DESC\n" +
            "LIMIT 6", nativeQuery = true)
    List<Long[]> findHotTagsByPost(List<Post> postList);

    @Query(value = "SELECT tag_id, count(tag_id) as nums FROM moview.tag_connect_post\n" +
            "GROUP BY tag_id\n" +
            "ORDER BY nums DESC\n" +
            "LIMIT 6", nativeQuery = true)
    List<Long[]> findHotTags();

}
