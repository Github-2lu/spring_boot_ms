package com.tulu.reviewms.review;

import java.util.List;

public interface ReviewService {
    public List<Review> findAll(Long comp_id);
    public boolean createReview(Review review, Long companyId);
    public Review findById(Long rev_id);
    public boolean updateById(Long rev_id, Review newReview);
    public boolean deleteById(Long rev_id);
}
