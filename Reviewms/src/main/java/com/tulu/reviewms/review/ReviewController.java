package com.tulu.reviewms.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAll(@RequestParam Long companyId){
        return ResponseEntity.ok(reviewService.findAll(companyId));
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review){
        if(reviewService.createReview(review, companyId)) {
            return ResponseEntity.ok("Review Added");
        }
        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{rev_id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long rev_id){
        Review review = reviewService.findById(rev_id);

        if(review != null){
            return ResponseEntity.ok(review);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{rev_id}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long rev_id, @RequestBody Review review){
        if(reviewService.updateById(rev_id, review)){
            return new ResponseEntity<>("Update Successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update Failed", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{rev_id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long rev_id){
        if(reviewService.deleteById(rev_id)){
            return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete Unsuccessful", HttpStatus.NOT_FOUND);
    }
}
