package TTT;

import com.stylefeng.guns.common.persistence.model.Warehouse;
import com.stylefeng.guns.common.persistence.dao.WarehouseMapper;
import TTT.IWarehouseService;
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
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements IWarehouseService {
	
}
