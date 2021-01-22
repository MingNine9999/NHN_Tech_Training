package RookieFox.mreview.entity;

import lombok.*;

import javax.persistence.*;
import java.nio.channels.FileLock;
import java.util.zip.GZIPInputStream;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "movie")
public class MovieImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;

    private String uuid;
    private String imgName;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

}
