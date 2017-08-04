package TTT;

import com.stylefeng.guns.common.persistence.model.Notice;
import com.stylefeng.guns.common.persistence.dao.NoticeMapper;
import TTT.INoticeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-03
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {
	
}
