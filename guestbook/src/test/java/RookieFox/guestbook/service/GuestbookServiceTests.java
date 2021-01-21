package RookieFox.guestbook.service;

import RookieFox.guestbook.dto.GuestbookDTO;
import RookieFox.guestbook.dto.PageRequestDTO;
import RookieFox.guestbook.dto.PageResultDTO;
import RookieFox.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title..........")
                .content("Sample Content........................................")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDTO));

    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("Prev: " + resultDTO.isPrev());
        System.out.println("Next: " + resultDTO.isNext());
        System.out.println("Total: " + resultDTO.getTotalPage());

        System.out.println("------------------------------");
        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }

        System.out.println("==============================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }

    @Test
    public void testSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tc")
                .keyword("sdf")
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("Prev: " + resultDTO.isPrev());
        System.out.println("Next: " + resultDTO.isNext());
        System.out.println("Total: " + resultDTO.getTotalPage());

        System.out.println("--------------------------");
        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }
        System.out.println("==========================");

        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
