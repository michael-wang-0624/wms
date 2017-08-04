package TTT;

import com.stylefeng.guns.common.persistence.model.Dict;
import com.stylefeng.guns.common.persistence.dao.DictMapper;
import TTT.IDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-03
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {
	
}
