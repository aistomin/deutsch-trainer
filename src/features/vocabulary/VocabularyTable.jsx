import React from 'react';
import {Paper, Table, TableBody, TableCell, tableCellClasses, TableContainer, TableHead, TableRow} from "@mui/material";
import {styled} from "@mui/material/styles";
import {useSelector} from "react-redux";
import {
    selectAllVocabularyItems,
    useGetVocabularyItemsQuery
} from "./vocabularySlice.jsx";

const VocabularyTable = () => {
    const {
        isLoading,
        isSuccess,
        isError,
        error
    } = useGetVocabularyItemsQuery()

    const rows = useSelector(selectAllVocabularyItems)

    const StyledTableCell = styled(TableCell)(({theme}) => ({
        [`&.${tableCellClasses.head}`]: {
            backgroundColor: '#800080',
            color: theme.palette.common.white,
        },
        [`&.${tableCellClasses.body}`]: {
            fontSize: 14,
        },
    }));

    let content;
    if (isLoading) {
        content = <p>"Loading..."</p>;
    } else if (isSuccess) {
        content = <TableContainer component={Paper}>
            <Table sx={{minWidth: 650}} aria-label="simple table">
                <TableHead>
                    <TableRow sx={{border: 1}}>
                        <StyledTableCell align="center">German</StyledTableCell>
                        <StyledTableCell align="center">English</StyledTableCell>
                        <StyledTableCell align="center">+</StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map((row) => (
                        <TableRow
                            key={row.id}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <StyledTableCell align="center">{row.german}</StyledTableCell>
                            <StyledTableCell align="center">{row.english}</StyledTableCell>
                            <StyledTableCell align="center">...</StyledTableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>;
    } else if (isError) {
        content = <p>{error}</p>;
    }
    return content;
};

export default VocabularyTable;
