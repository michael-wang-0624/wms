package TTT;

import com.stylefeng.guns.common.persistence.model.Storege;
import com.stylefeng.guns.common.persistence.dao.StoregeMapper;
import TTT.IStoregeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-03
 */
@Service
public class StoregeServiceImpl extends ServiceImpl<StoregeMapper, Storege> implements IStoregeService {
	
}
