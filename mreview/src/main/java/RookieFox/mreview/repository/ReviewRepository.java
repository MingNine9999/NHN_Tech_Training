package RookieFox.mreview.repository;

import RookieFox.mreview.entity.Member;
import RookieFox.mreview.entity.Movie;
import RookieFox.mreview.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths =  {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    //@Modifying
    //@Query("DELETE FROM Review mr " + "WHERE mr.member = :member")
    void deleteByMember(Member member);
}
