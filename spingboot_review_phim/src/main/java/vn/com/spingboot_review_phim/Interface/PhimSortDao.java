package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.com.spingboot_review_phim.Model.Phim;
import vn.com.spingboot_review_phim.Model.PhimViewModel;

public interface PhimSortDao extends PagingAndSortingRepository<Phim, String> {
}
