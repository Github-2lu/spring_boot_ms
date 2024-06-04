package com.tulu.reviewms.review.impl;
import com.tulu.reviewms.review.Review;
import com.tulu.reviewms.review.ReviewRepository;
import com.tulu.reviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll(Long companyId){
        return reviewRepository.findByCompanyId(companyId);
    }

    public boolean createReview(Review review, Long companyId){
        if(companyId != null && review != null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    public Review findById(Long rev_id){
        return reviewRepository.findById(rev_id).orElse(null);
    }

    public boolean updateById(Long rev_id, Review newReview){
        Optional<Review> filteredReview = reviewRepository.findById(rev_id);

        if(filteredReview.isPresent()){
            Review oldReview = filteredReview.get();
            oldReview.setTitle(newReview.getTitle());
            oldReview.setDescription(newReview.getDescription());
            oldReview.setRating(newReview.getRating());
            reviewRepository.save(oldReview);
            return true;
        }
        return false;
    }

    public boolean deleteById(Long rev_id){
//        List<Review> comp_reviews = reviewRepository.findByCompanyId(comp_id);
//
//        for(Review review: comp_reviews){
//            if(review.getId().equals(rev_id)){
//                reviewRepository.deleteById(rev_id);
//                return true;
//            }
//        }
//        return false;

        Review review = reviewRepository.findById(rev_id).orElse(null);

        if(review != null){
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }
}
