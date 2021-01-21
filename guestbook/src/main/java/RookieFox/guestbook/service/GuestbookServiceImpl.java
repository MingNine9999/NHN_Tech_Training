package RookieFox.guestbook.service;

import RookieFox.guestbook.dto.GuestbookDTO;
import RookieFox.guestbook.dto.PageRequestDTO;
import RookieFox.guestbook.dto.PageResultDTO;
import RookieFox.guestbook.entity.Guestbook;
import RookieFox.guestbook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.bridge.MessageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{

    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO.............");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return dto.getGno();
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        Page<Guestbook> result = repository.findAll(pageable);

        Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);
    }
}
