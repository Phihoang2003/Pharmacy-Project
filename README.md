# Pharmacy-Project
Phần mềm chỉ phục vụ cho dược sĩ bán hàng và người quản lý để thực hiện công việc như: quản lý thuốc và các mảng liên quan đến thuốc, các quản lý bán hàng và báo cáo thống kê. <br>
Bộ phận quản lý của cửa hàng gốm một quản lý có toàn quyền quản lý hệ thống, dược sĩ đảm nhận các công việc khác như bán hàng, ghi nhận các thông tin về khách hàng và in ấn các hóa đơn. Quản lý có thể thêm, cập nhật, tìm, xóa, sửa sản phẩm cũng như thông tin nhân viên.<br>
Quản lý thuốc bao gồm các công việc nhập thuốc, tìm kiếm thuốc, kiểm tra danh mục đầu thuốc và tình trạng thuốc. Bộ phận quản lý thuốc phải kiểm tra được về các thông tin thuốc như mã thuốc, tên thuốc, đơn vị thuốc, đơn giá, nhà cung cấp. Chức năng nhập thuốc cho phép theo dõi số lượng thuốc nhập vào, đơn giá, tổng tiền và theo dõi được thuốc nhập vào từ hãng nào, hạn sử dụng còn hay hết, giúp nhà thuốc quản lý thông tin, hóa đơn nhập một cách khoa học và chặt chẽ.<br>
Thuốc còn 2 tháng hạn sử dụng thì hệ thống sẽ phát thông báo để dược sĩ ưu tiên bán trước.<br>
Mỗi một loại hàng thường gồm nhiều mặt hàng. Mỗi một mặt hàng được nhận biết qua tên hàng, đơn vị tính, giá đề nghị và được gán cho một mã số được gọi là mã hàng (SKU) để tiện việc theo dõi. Ví dụ: Mỗi loại thuốc sẽ nằm trong 1 danh mục sản phẩm: thuốc cảm, thuốc đau đầu, hạ sốt… Ngoài ra còn có các sản phẩm không phải thuốc như khẩu trang y tế…<br>
Khi dược sĩ bán thuốc thì sẽ hiện form bao gồm tên thuốc, loại thuốc, hoạt chất, nước sản xuất, quy cách đóng gói. Hệ thống sẽ phát cảnh báo về tương tác thuốc nếu dược sĩ cho 2 loại hoạt chất xung khắc nhau vào giỏ thuốc.<br>
Khi khách hàng mua thì sẽ lưu thông tin khách hàng và lịch sử mua hàng. Thông tin khách hàng bao gồm họ tên khách hàng, số điện thoại. Sau mỗi lần mua hàng thì hệ thống sẽ tích điểm cho khách hàng.<br>
Sau khi người quản lý tạo tài khoản thì sẽ vào mục phân quyền để phân quyền cho tài khoản.<br>
Mã khuyến mãi chỉ có người quản lý mới có quyền tạo, bao gồm số tiền được khuyến mãi, thời gian khuyến mãi và số lượng khuyến mãi. Hết thời gian khuyến mãi, mã sẽ được thay đổi trạng thái từ “hiệu lực” sang “hết hiệu lực”. Người quản lý hay nhân viên có thể thống kê số lượng mã đã tạo theo tháng hoặc năm.<br>
Khi nhập hàng về phải làm thủ tục nhập kho. Mỗi lần nhập kho một hóa đơn nhập được lập do quản lý lập và chịu trách nhiệm kiểm tra về số lượng và chất lượng hàng nhập về. Trên phiếu nhập có ghi rõ mã số và tên của nhà cung cấp để sau này tiện theo dõi; các mặt hàng, số lượng, hạn sử dụng, ngày nhập kho, đơn giá mua và thành tiền tương ứng. Khi nhập hàng thì sẽ có giá nhập, công thức tính cho từng sản phẩm để cho ra đơn giá bán.<br>
Mỗi loại thuốc có mã thuốc, tên thuốc, loại thuốc, ngày sản xuất, hạn sử dụng, số lượng. Nếu thuốc sắp đến ngày hết hạn, phần mềm sẽ gửi thông báo để dược sĩ ưu tiên bán trước. Đối với thuốc đã hết hạn, thuốc sẽ được đưa vào mục “Thuốc hết hạn”. Trước khi đem tiêu hủy, quản lý sẽ thực hiện đối chiếu dữ liệu trong mục “Thuốc hết hạn” và hạn sử dụng ở bao bì sử dụng xem có khớp không, đề phòng trường hợp nhân viên nhập sai hạn sử dụng. Nếu thuốc nằm trong mục “Thuốc hết hạn” nhưng thực tế vẫn còn hạn sử dụng thì người quản lý có thể đưa thuốc ra khỏi mục “Thuốc hết hạn” bằng cách thay đổi hạn sử dụng của thuốc.<br>
Mỗi loại thuốc được đóng gói theo các đơn vị đóng gói khác nhau, ví dụ 1 hộp Panadol Extra bao gồm 15 vỉ, mỗi vỉ 12 viên, tổng là 180 viên. Khi nhập hàng, dược sĩ nhập số vỉ trong 1 hộp và số viên thuốc trong 1 vỉ. Khi bán hàng, hệ thống sẽ yêu cầu dược sĩ chọn bán theo quy chuẩn đóng gói nào, nếu bán lẻ thì chọn bán theo viên và nhập số viên thuốc bán, nếu bán theo vỉ thì nhập số vỉ, tương tự với bán theo hộp.<br>
<br>
Để đề phòng trường hợp dược sĩ quên một số loại thuốc phải có kê đơn của bác sĩ mới được phép bán cho người mua, khi dược sĩ thêm loại thuốc yêu cầu phải có kê đơn vào giỏ hàng, hệ thống sẽ hiển thị cảnh báo đây là thuốc yêu cầu kê đơn.<br>
Khi bán hàng cho khách hàng thì một hóa đơn xuất được lập. Hóa đơn xuất chỉ do một dược sĩ lập và chỉ xuất cho một khách hàng. Nếu trong quá trình thanh toán khách hàng gặp trục trặc thì có thể lưu tạm hóa đơn để thanh toán sau.<br>
Chức năng quản lý thu chi cần thu theo ca làm việc, theo tên dược sĩ bán thuốc, theo toa thuốc của bác sĩ. Một ngày quầy thuốc phân chia dược sĩ ra thành 2 ca làm việc, ca thứ nhất từ 6g sáng đến 2g chiều, ca thứ 2 từ 2g chiều đến 10g đêm. Trước khi vào ca, nhân viên phải đăng nhập vào tài khoản để tính ca làm. Nếu có vấn đề gì xảy ra thì quản lý có thể tìm nhân viên làm ca đó, ngày đó bằng hệ thống để truy cứu.<br>
Quy trình kiểm kê giúp nhà thuốc kiểm soát tình trạng tồn kho của sản phẩm, đảm bảo cung cấp đủ thuốc cho khách hàng.<br>
Cuối mỗi ngày bộ phận thống kê đều phải thống kê tất cả lập tổng số thuốc đã bán, lập tổng số còn lại, lập số thuốc hết hạn, tổng hợp tình hình thu chi và tổng số thuốc mới nhập của quầy thuốc sau khi thống kê tất cả các thông tin thì bộ phận thống kê phải báo cáo lại với nhà quản lý. Hệ thống cho phép thống kê doanh thu theo ngày, tháng hoặc năm.<br>
# Quy trình nghiệp vụ
Quy trình bán hàng: dược sĩ nhập thông tin khách hàng, kiểm tra khách hàng có trong hệ thống chưa, nếu chưa thì thêm khách hàng vào hệ thống. dược sĩ kiểm tra xem khách mua thuốc có kê đơn của bác sĩ hay không, sau đó thêm các sản phẩm vào giỏ hàng, xác nhận đơn hàng và in hóa đơn bán hàng.<br>
# Quy trình nhập hàng: 
Nếu nhập một sản phẩm mới: Người quản lý thêm nhà cung cấp thuốc, thêm sản phẩm cần nhập, chọn ngày nhập, loại sản phẩm, đơn vị đóng gói, nhập đơn giá nhập, tên sản phẩm, số lượng nhập, hạn sử dụng, sau khi xong thì chọn xác nhận nhập hàng và in hóa đơn nhập hàng, hệ thống sẽ có công thức tự động quy đổi ra đơn giá bán, mã sản phẩm cũng do hệ thống tự thực hiện.<br>
Nếu sản phẩm đã có sẵn thì người quản lý nhập số lượng nhập thêm để số lượng trong kho được cập nhật, nếu trước đó sản phẩm đang ở trạng thái hết hàng thì được đổi sang trạng thái còn hàng.<br>
Quy trình kiểm kê: dược sĩ lập danh sách sản phẩm cần kiểm kê sau đó tiến hành kiểm kê và nhập kết quả kiểm kê vào hệ thống.<br>
# Quy định:<br>
Nếu bán mặt hàng không kê đơn thì nhà thuốc không cần kiểm tra nguyên nhân bệnh của khách hàng mà chỉ cần kiểm tra loại thuốc khách hàng muốn mua có phải thuốc cần kê đơn hay không, nếu không thì mới được bán, còn nếu bán hàng theo kê đơn thì nhà thuốc cần kiểm tra thông tin khách hàng, kiểm tra nguyên nhân bệnh và lấy thuốc theo kê đơn sẵn của khách hàng.<br>
Nếu khách hàng muốn trả hàng thì buộc phải mang theo hoá đơn và thuốc phải còn nguyên chưa sử dụng, thời gian đổi trả là sau 14 ngày kể từ ngày mua trên hóa đơn.<br>
Theo đúng quy định của thực hành tốt nhà thuốc GPP, mỗi phần mềm gắn liền tài khoản, dữ liệu với 1 dược sĩ đã đăng ký, nếu đổi giấy phép đăng ký kinh doanh mới (đổi dược sĩ phụ trách) thì phần mềm sẽ được tạo lại mới từ đầu.<br>

# Ngoài những chức năng cơ bản như thêm, xóa, sửa khách hàng ra, phần mềm còn cần có những gì?
Cần có những những chức năng khác như nhập và xuất loại thuốc gì, tên ra sao, số lượng và giá cả, quản lý chung về thông tin của khách hàng, tìm kiếm theo tên khách hàng, lọc ra khách hàng mua đơn nhiều trong tháng.
Ngoài ra, phần mềm còn cần có chức năng thống kê thuốc theo lô và quản lý được số lượng thuốc gần hết hạn, đã hết hạn, chức năng tìm kiếm theo tên hoặc theo nhóm thuốc.

# Hiện nay có 2 kiểu lập mã sản phẩm là nhập thủ công và để hệ thống tự tạo, khách hàng chọn phương án nào?
Hệ thống sẽ tự động tạo ra một mã SKU duy nhất cho mỗi sản phẩm khi sản phẩm được thêm vào hệ thống, giúp đảm bảo rằng mỗi sản phẩm đều có một mã SKU duy nhất.
SKU - Stock Keeping Unit

# Nếu cùng 1 loại thuốc mà nhập 2 lô với 2 ngày sản xuất và hạn sử dụng khác nhau thì tạo mã SKU giống hay khác?
Trong trường hợp này, mã SKU sẽ riêng biệt cho mỗi lô thuốc. Mỗi lô thuốc, mặc dù cùng loại, nhưng có ngày sản xuất và hạn sử dụng khác nhau nên được coi như một đơn vị giữ hàng tồn riêng để người dùng theo dõi chính xác hạn sử dụng của từng lô thuốc, đảm bảo rằng thuốc được bán trước khi hết hạn.

# Phần mềm có tính năng ưu đãi cho khách hàng nếu khách hàng mua nhiều sản phẩm từ cửa hàng hay không? Ví dụ như giảm giá cho khách hàng trong lần mua tiếp theo dựa trên số liệu mua hàng trên phần mềm.
Phần mềm của nhà thuốc có ghi nhận lại thông tin mua hàng của khách hàng nếu số lượng mua hàng đạt tới mức được giảm giá thì trong lần mua tiếp theo khách hàng sẽ được hưởng khuyến mãi theo cơ chế tích điểm.

# Nếu khách hàng đã đăng ký nhưng sau một thời gian dài không quay lại mua sản phẩm của nhà thuốc nữa thì có xóa khách hàng đó ra khỏi kho lưu trữ của phần mềm hay không? Ví dụ như loại bỏ thông tin của khách hàng đó ra khỏi cơ sở dữ liệu của cửa hàng
Thông thường khi khách hàng sau một thời gian dài không hoạt động tại cửa hàng thì dược sĩ sẽ thay đổi trạng thái của khách hàng đó chứ không hoàn toàn loại bỏ khách hàng ra khỏi cơ sở dữ liệu lưu trữ của cửa hàng.

# Phần mềm có chức năng nào để quản lý thời gian và ca làm việc của dược sĩ hay không? Ví dụ như chức năng phân bổ dược sĩ làm việc theo ca nào, trong khoảng thời gian nào.
Tất nhiên phần mềm tại cửa hàng sẽ có tính năng phân chia ca làm việc cho dược sĩ và phân bổ khoảng thời gian hợp lý để kiểm soát quá trình làm việc của dược sĩ tại cửa hàng

# Hệ thống định giá thủ công hay định giá bằng công thức?
Hệ thống định giá bằng công thức: Giá bán lẻ = Giá mua vào + Mức thặng số bán lẻ (%) × Giá mua vào.
VD: Giá nhập là 10.000 đồng. Mức thặng số bán lẻ cho loại thuốc này là 15% → Giá bán là 15% x 10.000 đồng= 1.500 đồng

# Có quy định nào về việc đưa ra mức giá bán lẻ không?
- Đối với thuốc có giá mua tính trên đơn vị đóng gói nhỏ nhất nhỏ hơn hoặc bằng 1.000 đồng, mức thặng số bán lẻ là 15%;
- Đối với thuốc có giá mua tính trên đơn vị đóng gói nhỏ nhất từ trên 1.000 (một nghìn) đồng đến 5.000 (năm nghìn) đồng, mức thặng số bán lẻ là 10%;
- Đối với thuốc có giá mua tính trên đơn vị đóng gói nhỏ nhất từ trên 5.000 (năm nghìn) đồng đến 100.000 (một trăm nghìn) đồng, mức thặng số bán lẻ là 7%;
- Đối với thuốc có giá mua tính trên đơn vị đóng gói nhỏ nhất từ trên 100.000 (một trăm nghìn) đồng đến 1.000.000 (một triệu) đồng, mức thặng số bán lẻ là 5%;
- Đối với thuốc có giá mua tính trên đơn vị đóng gói nhỏ nhất trên 1.000.000 (một triệu) đồng, mức thặng số bán lẻ là 2%.
Mức thặng số bán lẻ được tính dựa trên nghị định 54/2017/NĐ-CP ngày ngày 08 tháng 5 năm 2017 của Chính phủ quy định chi tiết một số điều và biện pháp thi hành Luật dược.

# Đơn vị đóng gói nhỏ nhất được quy định như thế nào?
- Đối với dạng bào chế là viên, đơn vị đóng gói nhỏ nhất là viên;
- Đối với dạng bào chế là dạng lỏng, đơn vị đóng gói nhỏ nhất là ống, chai, lọ, túi, ống tiêm, bơm tiêm đóng sẵn thuốc;
- Đối với dạng bào chế là dạng bột pha tiêm, đơn vị đóng gói nhỏ nhất là ống, chai, lọ, túi, ống tiêm, bơm tiêm đóng sẵn thuốc;
- Đối với dạng bào chế là dạng bột, cốm pha uống, đơn vị đóng gói nhỏ nhất là gói, chai, lọ, túi;
- Đối với dạng bào chế là kem, mỡ, gel dùng ngoài, đơn vị đóng gói nhỏ nhất là tuýp, lọ;
- Đối với dạng bào chế là thuốc dán, đơn vị đóng gói nhỏ nhất là miếng dán;
- Đối với dạng bào chế là thuốc xịt hay thuốc khí dung, đơn vị đóng gói nhỏ nhất là bình xịt, chai xịt, lọ xịt hoặc lọ đựng thuốc dùng cho máy khí dung;
- Đối với dạng bào chế là bộ kít phối hợp, đơn vị đóng gói nhỏ nhất là bộ kít.

# Sau bao lâu thì hệ thống sẽ báo thuốc sắp hết hạn và hết hạn?
Khi thuốc còn đúng 2 tháng là hết hạn, hệ thống sẽ phát thông báo thuốc sắp hết hạn. 
Nếu thuốc hết hạn thì hệ thống sẽ phát thông báo và trừ số lượng trong kho hàng, sau đó đẩy sản phẩm vào mục thuốc hết hạn.
